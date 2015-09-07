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
/**
 * 
 */
package com.vaadin.terminal.gwt.client.ui.dd;

import com.vaadin.terminal.gwt.client.UIDL;

/**
 * 
 */
final public class VOr extends VAcceptCriterion implements VAcceptCallback {
    private boolean accepted;

    @Override
    public void accept(VDragEvent drag, UIDL configuration,
            VAcceptCallback callback) {
        int childCount = configuration.getChildCount();
        accepted = false;
        for (int i = 0; i < childCount; i++) {
            VAcceptCriterion crit = VAnd.getCriteria(drag, configuration, i);
            crit.accept(drag, configuration.getChildUIDL(i), this);
            if (accepted == true) {
                callback.accepted(drag);
                return;
            }
        }
    }

    @Override
    public boolean needsServerSideCheck(VDragEvent drag, UIDL criterioUIDL) {
        return false;
    }

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        return false; // not used here
    }

    public void accepted(VDragEvent event) {
        accepted = true;
    }

}
