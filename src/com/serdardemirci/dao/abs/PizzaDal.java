package com.serdardemirci.dao.abs;

import com.serdardemirci.core.dao.AddSauce;
import com.serdardemirci.core.dao.AddIngredient;
import com.serdardemirci.core.dao.Get;
import com.serdardemirci.domain.Pizza;

public interface PizzaDal extends Get<Pizza>, AddSauce, AddIngredient {
}
