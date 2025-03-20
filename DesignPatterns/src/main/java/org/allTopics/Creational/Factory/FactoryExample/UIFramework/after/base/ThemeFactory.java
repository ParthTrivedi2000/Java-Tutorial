package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.IOSUI.IOSUITheme;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.MaterialUI.MaterialUITheme;

public class ThemeFactory {
    public static Theme createThemeByPlatformName(String themeName) {
        if(themeName.equals("ios")) {
            return new IOSUITheme();
        }
        else if(themeName.equals("material")) {
            return new MaterialUITheme();
        }
        else {
            throw new Error("Unsupported theme: " + themeName);
        }
    }
}
