package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.IOSUI;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Button;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.DropDown;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Menu;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.ThemeComponentFactory;

public class IOSUIThemeComponentFactory implements ThemeComponentFactory {

    @Override
    public Button createButton() {
        return new IOSUIButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSUIMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new IOSUIDropDown();
    }
}
