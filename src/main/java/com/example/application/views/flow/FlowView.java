package com.example.application.views.flow;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Flow view")
@Route(value = "flow")
public class FlowView extends VerticalLayout {

    public FlowView() {
        // Task 1:
        // 1. Create a "Playback Speed" control slider for a video player with:
        // min of 0.5x, max of 3.0x, an interval of 0.25x, and an initial value of 1.0x.
        // 2. Add a label and helper text
        // 3. Configure the slider to show actual values of the minimum and maximum
        // selectable speed (0.5 and 3.0)
        // 4. Make the value bubbles on the slider thumbs permanently visible
        // 5. Change the step to 0.1x
        // 6, Change the min and max speed to 0.1x and 3.9x respectively

        // Task 2:
        // 1. Create a "Stay Duration" range slider for hotel search with:
        // min of 1 day, max of 30 days, a step of 1 day, and an initial range of 5-10 days.
        // 2. Show the selected range in a separate paragraph next to the range slider,
        // automatically updating the displayed value as the user drags the slider.
        // 3. Using Binder, implement validation requiring the stay duration to be at least 3 days
        // 4. Improve accessibility by providing custom ARIA labels for the start and end thumbs:
        // “Minimum stay” and “Maximum stay”
    }
}
