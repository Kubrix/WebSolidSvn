package com;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


/**
 * Created by kalistrat on 19.12.2017.
 */
public class mainView extends CustomComponent implements View {
    public static final String NAME = "";

    String currentUser;

    Button LogOutButton = new Button("Выйти", new Button.ClickListener() {
        @Override
        public void buttonClick(Button.ClickEvent event) {
            // "Logout" the user
            getSession().setAttribute("user", null);
            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });


    private TabSheet tabSheet;


    public mainView(){

    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {

        this.currentUser = (String) getSession().getAttribute("user");

        VerticalLayout mainViewContent = new VerticalLayout();
        LogOutButton.addStyleName(ValoTheme.BUTTON_LINK);
        LogOutButton.addStyleName(ValoTheme.BUTTON_SMALL);
        LogOutButton.setIcon(FontAwesome.SIGN_OUT);

        HorizontalLayout TopSec = new HorizontalLayout(LogOutButton);
        TopSec.setComponentAlignment(LogOutButton,Alignment.TOP_RIGHT);

        TopSec.setHeight("90px");
        TopSec.setWidth("100%");

        mainViewContent.setSizeFull();

        HorizontalSplitPanel treeSection = new HorizontalSplitPanel();

        treeSection.setSizeFull();
        treeSection.setSplitPosition(35, Unit.PERCENTAGE);

        mainViewContent.addComponent(TopSec);

        VerticalLayout Tab1Cont = new VerticalLayout();
        Tab1Cont.addComponent(treeSection);
        Tab1Cont.setWidth("100%");
        Tab1Cont.setHeight("500px");

        VerticalLayout Tab2Cont = new VerticalLayout();

        Table table = new Table("Таблица доступна");

        //Tab2Cont.addComponent(new Label("Здесь был Дима"));
        tabSheet = new TabSheet();

        tabSheet.addTab(Tab1Cont, "Дерево моделей", VaadinIcons.FILE_TREE);
        tabSheet.addTab(Tab2Cont, "Личные сообщения", VaadinIcons.CHAT);

        tabSheet.setSizeFull();

        mainViewContent.addComponent(tabSheet);

        setCompositionRoot(mainViewContent);
    }
}
