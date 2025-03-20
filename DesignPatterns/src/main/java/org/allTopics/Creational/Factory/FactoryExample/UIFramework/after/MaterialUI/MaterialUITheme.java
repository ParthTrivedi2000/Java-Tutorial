package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.MaterialUI;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Theme;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.ThemeComponentFactory;

public class MaterialUITheme extends Theme {


    @Override
    public ThemeComponentFactory createThemeComponentFactory() {
        return new MaterialUIThemeComponentFactory();
    }

    @Override
    public boolean changePrimaryColor() {
        return false;
    }
}
