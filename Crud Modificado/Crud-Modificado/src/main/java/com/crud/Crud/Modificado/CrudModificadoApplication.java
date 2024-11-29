/*package com.crud.Crud.Modificado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudModificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudModificadoApplication.class, args);
	}

}*/
package com.crud.Crud.Modificado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = "com.crud.Crud.Modificado")
public class CrudModificadoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudModificadoApplication.class, args);
	}
}
