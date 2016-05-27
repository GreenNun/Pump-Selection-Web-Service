package eu.bausov.projects.pump_selector.bo;

import eu.bausov.projects.pump_selector.utils.priceis_and_currency_convertor.Price;

/**
 * Created by Stanislav Bausov on 22.05.2016.
 */
public abstract class Equipment {
    Producer producer;
    String modelName;
    Price price;
}
