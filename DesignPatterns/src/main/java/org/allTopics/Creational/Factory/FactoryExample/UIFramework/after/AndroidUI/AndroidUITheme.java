package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.AndroidUI;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Theme;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.ThemeComponentFactory;

public class AndroidUITheme extends Theme {
    @Override
    public ThemeComponentFactory createThemeComponentFactory() {
        return null;
    }

    @Override
    public boolean changePrimaryColor() {
        return false;
    }
}
