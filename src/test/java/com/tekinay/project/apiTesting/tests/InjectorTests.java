package com.tekinay.project.apiTesting.tests;

import com.tekinay.project.apiTesting.testFramework.controll.ConnectionManager;
import com.tekinay.project.apiTesting.testFramework.model.Injector;
import com.tekinay.project.apiTesting.testFramework.model.dto.BrandsListDTO;
import com.tekinay.project.apiTesting.testFramework.model.dto.ProductListDTO;
import com.tekinay.project.apiTesting.testFramework.model.dto.UserAccountDTO;
import com.tekinay.project.apiTesting.testFramework.model.dto.UserCredentialsDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InjectorTests {

    public static ProductListDTO productListDTO;
    public static BrandsListDTO brandsListDTO;
    public static UserAccountDTO userAccountDTO;
    public static UserCredentialsDTO userCredentialsDTO;

    @Test
    @DisplayName("Check that the deserialize method will return an appropriate Java object")
    void checkThatTheDeserializeMethodWillReturnAnAppropriateJavaObject() {
        //Arrange
        productListDTO = new ProductListDTO();
        brandsListDTO = new BrandsListDTO();
        userAccountDTO = new UserAccountDTO();
        userCredentialsDTO = new UserCredentialsDTO();
        //Act
        productListDTO = (ProductListDTO) Injector.deserialize(productListDTO, ConnectionManager.Method.GET,"productsList");
        brandsListDTO = (BrandsListDTO) Injector.deserialize(brandsListDTO, ConnectionManager.Method.GET,"brandsList");
        userAccountDTO = (UserAccountDTO) Injector.deserialize(userAccountDTO, ConnectionManager.Method.GET,"getUserDetailByEmail");
        userCredentialsDTO = (UserCredentialsDTO) Injector.deserialize(userCredentialsDTO, ConnectionManager.Method.GET,"verifyLogin");
        //Assert
        assertInstanceOf(ProductListDTO.class, productListDTO);
        assertInstanceOf(BrandsListDTO.class, brandsListDTO);
        assertInstanceOf(UserAccountDTO.class, userAccountDTO);
        assertInstanceOf(UserCredentialsDTO.class, userCredentialsDTO);
    }
}