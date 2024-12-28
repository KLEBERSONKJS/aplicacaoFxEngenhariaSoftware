module com.ads.projetoengenhariasoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires javafx.base;
    requires java.desktop;
    requires dom4j;
    requires org.kordamp.bootstrapfx.core;

    opens com.ads.projetoengenhariasoftware.controller to javafx.fxml;
    opens com.ads.projetoengenhariasoftware.model to javafx.base, javafx.fxml, org.hibernate.orm.core;

    opens com.ads.projetoengenhariasoftware to javafx.fxml;

    exports com.ads.projetoengenhariasoftware;
    exports com.ads.projetoengenhariasoftware.model;
}