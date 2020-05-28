package br.com.fiap.ecommerce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {

	@Autowired
	private TypeResolver typeResolver;
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessageForGET())
				.alternateTypeRules( 
				                      AlternateTypeRules.newRule(
				                    		                       typeResolver.resolve(InputStreamResource.class),
				                    		                       typeResolver.resolve(Error.class)
				                                                )
				                   );
	}

	@SuppressWarnings("serial")
	private List<ResponseMessage> responseMessageForGET() {
		
		return new ArrayList<ResponseMessage>() {
			{
				add(new ResponseMessageBuilder()
						.code(500).message("Internal 'Server Error")
						.responseModel(new ModelRef("Error"))
						.build());
				add(new ResponseMessageBuilder()
						.code(400).message("Bad Request")
						.build());
				add(new ResponseMessageBuilder()
						.code(403).message("Forbidden")
						.build());
				add(new ResponseMessageBuilder()
						.code(404).message("Not Found")
						.build());
			}
		};
	}
}