package scriptSQL;

import java.sql.Connection;
import java.sql.Statement;

public class scriptMigration {

    private String SQL;
    private Statement st;

    public scriptMigration(Connection cn) {

        SQL = "CREATE TABLE banco (\n"
                + "	id serial NOT NULL,\n"
                + "	descripcion varchar(250) NULL,\n"
                + "	estado int4 NULL DEFAULT 1,\n"
                + "	fecha_h_input timestamp NULL DEFAULT now(),\n"
                + "	fecha_h_update timestamp NULL,\n"
                + "	usuario_input int4 NULL DEFAULT 1,\n"
                + "	usuario_update int4 NULL,\n"
                + "	CONSTRAINT banco_pkey PRIMARY KEY (id)\n"
                + ");";

        SQL += "CREATE TABLE cargo (\n"
                + "	id serial NOT NULL,\n"
                + "	descripcion varchar(250) NULL,\n"
                + "	estado int4 NULL DEFAULT 1,\n"
                + "	usuario_input int4 NULL DEFAULT 1,\n"
                + "	usuario_update int4 NULL,\n"
                + "	fecha_h_input timestamp NULL DEFAULT now(),\n"
                + "	fecha_h_update timestamp NULL,\n"
                + "	CONSTRAINT cargo_pkey PRIMARY KEY (id)\n"
                + ");";
    }

}
