package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.WindowsUI;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Button;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.DropDown;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Menu;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.ThemeComponentFactory;

public class WindowsUIThemeComponentFactory implements ThemeComponentFactory {
    @Override
    public Button createButton() {
        return new WindowsUIButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsUIMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new WindowsUIDropDown();
    }
}
