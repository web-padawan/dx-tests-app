import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { IntegerField, Tooltip, VerticalLayout } from '@vaadin/react-components';

export const config: ViewConfig = { title: 'CVV Field (React)' };

export default function CvvFieldView() {
  // TODO:
  // 1. Replace the existing tooltip with the popup that would contain the current text
  //    plus the "Example" link pointing to the URL https://www.cvvnumber.com/cvv.html
  // 2. Make sure the popup opens either when moving the cursor over the field or when
  //    focusing it with keyboard (similarly to how it was working when using tooltip).
  // 3. Configure the popup to have 500 ms timeout before opening and closing.
  // 4. Configure the popup to show above the field, same as it was with the tooltip.
  // 5. Limit the width of the popup content to 200px so that the text would wrap.
  // 6. Configure the popup to show an arrow pointing in the direction of the field.

  return (
    <VerticalLayout theme="padding spacing">
      <IntegerField label="CVV" max={999} style={{ width: '70px' }}>
        <Tooltip slot="tooltip" text="3 digit code printed on the back of the card." />
      </IntegerField>
    </VerticalLayout>
  );
}
