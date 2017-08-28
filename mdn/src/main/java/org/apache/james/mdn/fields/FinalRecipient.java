/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.mdn.fields;

import org.apache.james.mdn.Constants;

import com.google.common.base.Preconditions;

public class FinalRecipient implements Field {
    public static final String FIELD_NAME = "Final-Recipient";

    private final Text finalRecipient;
    private final String addressType;

    public FinalRecipient(String addressType, Text finalRecipient) {
        Preconditions.checkNotNull(finalRecipient);
        Preconditions.checkNotNull(addressType);
        this.finalRecipient = finalRecipient;
        this.addressType = addressType;
    }

    public FinalRecipient(Text finalRecipient) {
        this(Constants.RFC_822, finalRecipient);
    }

    public Text getFinalRecipient() {
        return finalRecipient;
    }

    @Override
    public String formattedValue() {
        return FIELD_NAME + ": " + addressType + "; " + finalRecipient.formatted();
    }
}
