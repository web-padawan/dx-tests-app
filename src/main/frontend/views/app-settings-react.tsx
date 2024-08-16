import { useEffect, useState } from 'react';
import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { Button, Dialog, Icon, RadioButton, RadioGroup, VerticalLayout } from '@vaadin/react-components';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';

export const config: ViewConfig = { title: 'App Settings (React)' };

export default function AppSettingsView() {
  // TODO:
  // 1. Change "Settings" form to open in the popover below the button instead of the dialog.
  // 2. Make the other elements on the page greyed out when "Settings" popover is open,
  //    similarly to how it was looking when the dialog was used.
  // 3. Add "Close" button to the popover, make it close the popover.
  // 4. Disallow closing the popover by Esc key and outside click, so that it can be only
  //    closed by pressing the "Close" button.

  const [theme, setTheme] = useState<string>(document.body.getAttribute('theme') || 'light');
  const [direction, setDirection] = useState<string>(document.documentElement.getAttribute('dir') || 'ltr');

  useEffect(() => {
    if (theme === 'dark') {
      document.body.setAttribute('theme', 'dark');
    } else {
      document.body.removeAttribute('theme');
    }
  }, [theme]);

  useEffect(() => {
    if (direction === 'rtl') {
      document.documentElement.setAttribute('dir', 'rtl');
    } else {
      document.documentElement.removeAttribute('dir');
    }
  }, [direction]);

  return (
    <>
      <VerticalLayout theme="padding spacing">
        <Button theme="icon" onClick={() => setOpened(true)}>
          <Icon icon="lumo:cog" />
        </Button>
      </VerticalLayout>

      <Dialog headerTitle="Settings" opened={opened} onOpenedChanged={(e) => setOpened(e.detail.value)}>
        <VerticalLayout>
          <RadioGroup label="Theme" value={theme} onValueChanged={(e) => setTheme(e.detail.value)}>
            <RadioButton label="Light" value="light" />
            <RadioButton label="Dark" value="dark" />
          </RadioGroup>
          <RadioGroup label="Direction" value={direction} onValueChanged={(e) => setDirection(e.detail.value)}>
            <RadioButton label="LTR" value="ltr" />
            <RadioButton label="RTL" value="rtl" />
          </RadioGroup>
        </VerticalLayout>
      </Dialog>
    </>
  );
}
