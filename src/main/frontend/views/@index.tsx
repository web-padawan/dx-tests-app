import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { Button, VerticalLayout } from '@vaadin/react-components';

export const config: ViewConfig = { menu: { order: 0 }, title: 'React View' };

export default function ReactView() {
  return (
    <VerticalLayout theme="padding spacing">
      <Button>
        Click me
      </Button>
    </VerticalLayout>
  );
}
