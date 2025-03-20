package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.IOSUI;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Theme;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.ThemeComponentFactory;

public class IOSUITheme extends Theme {

    @Override
    public ThemeComponentFactory createThemeComponentFactory() {
        return new IOSUIThemeComponentFactory();
    }

    @Override
    public boolean changePrimaryColor() {
        return false;
    }
}
