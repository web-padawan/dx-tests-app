import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { VerticalLayout } from '@vaadin/react-components';

export const config: ViewConfig = { title: 'React view' };

export default function ReactView() {
  return (
    <>
      <VerticalLayout theme="padding spacing"></VerticalLayout>
    </>
  );
}
