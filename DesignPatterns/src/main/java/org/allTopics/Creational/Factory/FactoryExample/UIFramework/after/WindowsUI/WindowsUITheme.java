package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.WindowsUI;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Theme;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.ThemeComponentFactory;

public class WindowsUITheme extends Theme {
    @Override
    public ThemeComponentFactory createThemeComponentFactory() {
        return new WindowsUIThemeComponentFactory();
    }

    @Override
    public boolean changePrimaryColor() {
        return false;
    }
}
