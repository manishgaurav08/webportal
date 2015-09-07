/*
 * Copyright 2011 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.terminal.gwt.client;

import static com.vaadin.terminal.gwt.client.EventId.BLUR;
import static com.vaadin.terminal.gwt.client.EventId.FOCUS;

import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Helper class for attaching/detaching handlers for Vaadin client side
 * components, based on identifiers in UIDL. Helpers expect Paintables to be
 * both listeners and sources for events. This helper cannot be used for more
 * complex widgets.
 * <p>
 * Possible current registration is given as parameter. The returned
 * registration (possibly the same as given, should be store for next update.
 * <p>
 * Pseudocode what helpers do:
 * 
 * <pre>
 * 
 * if paintable has event listener in UIDL
 *      if registration is null
 *              register paintable as as handler for event
 *      return the registration
 * else 
 *      if registration is not null
 *              remove the handler from paintable
 *      return null
 * 
 * 
 * </pre>
 * 
 */
public class EventHelper {

    public static HandlerRegistration updateFocusHandler(Paintable paintable,
            ApplicationConnection client,
            HandlerRegistration handlerRegistration) {
        if (client.hasEventListeners(paintable, FOCUS)) {
            if (handlerRegistration == null) {
                handlerRegistration = ((HasFocusHandlers) paintable)
                        .addFocusHandler((FocusHandler) paintable);
            }
            return handlerRegistration;
        } else if (handlerRegistration != null) {
            handlerRegistration.removeHandler();
            handlerRegistration = null;

        }
        return null;
    }

    public static HandlerRegistration updateBlurHandler(Paintable paintable,
            ApplicationConnection client,
            HandlerRegistration handlerRegistration) {
        if (client.hasEventListeners(paintable, BLUR)) {
            if (handlerRegistration == null) {
                handlerRegistration = ((HasBlurHandlers) paintable)
                        .addBlurHandler((BlurHandler) paintable);
            }
            return handlerRegistration;
        } else if (handlerRegistration != null) {
            handlerRegistration.removeHandler();
            handlerRegistration = null;

        }
        return null;
    }

}
