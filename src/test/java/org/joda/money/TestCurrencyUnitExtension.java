/*
 *  Copyright 2009-present, Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.money;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Test CurrencyUnit.
 */
@Test
public class TestCurrencyUnitExtension {

    public void test_CurrencyFromMoneyData() {
        List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
        boolean found = false;
        for (CurrencyUnit currencyUnit : curList) {
            if (currencyUnit.getCode().equals("GBP")) {
                found = true;
                break;
            }
        }
        assertEquals(found, true);
    }

    public void test_CurrencyFromMoneyDataExtension() {
        List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
        boolean found = false;
        for (CurrencyUnit currencyUnit : curList) {
            if (currencyUnit.getCode().equals("BTC")) {
                found = true;
                break;
            }
        }
        assertEquals(found, true);
    }

    public void test_CurrencyMissing() {
        List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
        boolean found = false;
        for (CurrencyUnit currencyUnit : curList) {
            if (currencyUnit.getCode().equals("NMC")) {
                found = true;
                break;
            }
        }
        assertEquals(found, false);
    }

    public void test_MyCurrencies() {
        List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
        Map<String, CurrencyUnit> map = new HashMap<String, CurrencyUnit>();

        for (CurrencyUnit currencyUnit : curList) {
            map.put(currencyUnit.getCode(), currencyUnit);
        }

        assertNotNull(map.get("USDT"));
        assertNotNull(map.get("BTC"));

        assertNotNull(map.get("UP"));
        assertEquals(map.get("UP"), CurrencyUnit.of("UP"));
    }

    public void test_CurrencyEURChanged() {
        CurrencyUnit currency = CurrencyUnit.ofCountry("HU");
        assertEquals(currency, CurrencyUnit.EUR);
        assertEquals(CurrencyUnit.EUR.getCountryCodes().contains("HU"), true);
        assertEquals(CurrencyUnit.of("HUF").getCountryCodes().isEmpty(), true);
    }

}
