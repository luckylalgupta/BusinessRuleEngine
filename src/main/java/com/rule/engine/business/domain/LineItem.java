package com.rule.engine.business.domain;

import java.util.HashMap;

public class LineItem {
    public LineItem(final String _sku,final String _name, final ProductCategory[] categories) {
        this._sku = _sku;
        this._name = _name;
        this._categories = new HashMap<String, ProductCategory>();
        if(categories!=null){
            for(ProductCategory cat :categories){
                if(!this._categories.containsKey(cat.get_name()))
                    this._categories.put(cat.get_name(),cat);
            }
        }
    }

    private final String _sku;

    public String get_sku() {
        return this._sku;
    }
    public final String _name;
    public String get_name() {
        return this._name;
    }

    private final HashMap<String , ProductCategory> _categories;
        public boolean hasCategory(final ProductCategory category){
            return this._categories.containsKey(category.get_name());
        }
}
