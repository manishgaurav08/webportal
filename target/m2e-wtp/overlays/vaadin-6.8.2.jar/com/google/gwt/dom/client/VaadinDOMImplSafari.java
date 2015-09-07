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
package com.google.gwt.dom.client;

/**
 * Overridden to workaround GWT issue #6194. Remove this when updating to a
 * newer GWT that fixes the problem (2.3.0 possibly). Must be in this package as
 * the whole DOMImpl hierarchy is package private and I really did not want to
 * copy all the parent classes into this one...
 */
class VaadinDOMImplSafari extends DOMImplSafari {
    @Override
    public int getAbsoluteLeft(Element elem) {
        // Chrome returns a float in certain cases (at least when zoom != 100%).
        // The |0 ensures it is converted to an int.
        return super.getAbsoluteLeft(elem) | 0;
    }

    @Override
    public int getAbsoluteTop(Element elem) {
        // Chrome returns a float in certain cases (at least when zoom != 100%).
        // The |0 ensures it is converted to an int.
        return super.getAbsoluteTop(elem) | 0;
    }
}
