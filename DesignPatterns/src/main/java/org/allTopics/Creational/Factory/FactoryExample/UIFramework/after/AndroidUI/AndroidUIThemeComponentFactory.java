package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.AndroidUI;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Button;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.DropDown;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Menu;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.ThemeComponentFactory;

public class AndroidUIThemeComponentFactory implements ThemeComponentFactory {
    @Override
    public Button createButton() {
        return new AndroidUIButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidUIMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new AndroidUIDropDown();
    }
}
