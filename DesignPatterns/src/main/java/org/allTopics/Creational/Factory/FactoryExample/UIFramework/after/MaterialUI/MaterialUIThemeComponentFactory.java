package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.MaterialUI;

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Button;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.DropDown;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.Menu;
import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.ThemeComponentFactory;

public class MaterialUIThemeComponentFactory implements ThemeComponentFactory {
    @Override
    public Button createButton() {
        return new MaterialUIButton();
    }

    @Override
    public Menu createMenu() {
        return new MaterialUIMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new MaterialUIDropDown();
    }
}
