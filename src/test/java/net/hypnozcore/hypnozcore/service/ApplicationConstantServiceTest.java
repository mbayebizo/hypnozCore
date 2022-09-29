package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import net.hypnozcore.hypnozcore.dto.ApplicationConstantDto;
import net.hypnozcore.hypnozcore.mapper.ApplicationConstantMapper;
import net.hypnozcore.hypnozcore.models.ApplicationConstant;
import net.hypnozcore.hypnozcore.repository.ApplicationConstantRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ApplicationConstantServiceTest {
    @MockBean
    private ApplicationConstantMapper applicationConstantMapper;

    @MockBean
    private ApplicationConstantRepository applicationConstantRepository;

    @Autowired
    private ApplicationConstantService applicationConstantService;

    /**
     * Method under test: {@link ApplicationConstantService#save(ApplicationConstantDto)}
     */
    @Test
    void testSave() {
        ApplicationConstantDto applicationConstantDto = new ApplicationConstantDto();
        applicationConstantDto.setCode("Code");
        applicationConstantDto.setCreateAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        applicationConstantDto.setId(123L);
        applicationConstantDto.setLastModifiedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        applicationConstantDto.setLibelle("Libelle");
        applicationConstantDto.setNature("Nature");
        applicationConstantDto.setUesed(true);
        ApplicationConstantDto actualSaveResult = applicationConstantService.save(applicationConstantDto);
        assertEquals("Code", actualSaveResult.getCode());
        assertTrue(actualSaveResult.isUesed());
        assertEquals("Nature", actualSaveResult.getNature());
        assertEquals("Libelle", actualSaveResult.getLibelle());
    }

    /**
     * Method under test: {@link ApplicationConstantService#save(ApplicationConstantDto)}
     */
    @Test
    void testSave2() {
        ApplicationConstantDto applicationConstantDto = new ApplicationConstantDto();
        applicationConstantDto.setCode(
                "save(Lnet/hypnozcore/hypnozcore/dto/ApplicationConstantDto;)Lnet/hypnozcore/hypnozcore/dto/Applicati"
                        + "onConstantDto;");
        applicationConstantDto.setCreateAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        applicationConstantDto.setId(123L);
        applicationConstantDto.setLastModifiedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        applicationConstantDto.setLibelle("Libelle");
        applicationConstantDto.setNature("Nature");
        applicationConstantDto.setUesed(true);
        ApplicationConstantDto actualSaveResult = applicationConstantService.save(applicationConstantDto);
        assertEquals(
                "save(Lnet/hypnozcore/hypnozcore/dto/ApplicationConstantDto;)Lnet/hypnozcore/hypnozcore/dto/Applicati"
                        + "onConstantDto;",
                actualSaveResult.getCode());
        assertTrue(actualSaveResult.isUesed());
        assertEquals("Nature", actualSaveResult.getNature());
        assertEquals("Libelle", actualSaveResult.getLibelle());
    }

    /**
     * Method under test: {@link ApplicationConstantService#deleteById(String)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(applicationConstantRepository).deleteById((String) any());
        applicationConstantService.deleteById("42");
        verify(applicationConstantRepository).deleteById((String) any());
    }

    /**
     * Method under test: {@link ApplicationConstantService#deleteById(String)}
     */
    @Test
    void testDeleteById2() {
        doThrow(new ResourceNotFoundException("An error occurred")).when(applicationConstantRepository)
                .deleteById((String) any());
        assertThrows(ResourceNotFoundException.class, () -> applicationConstantService.deleteById("42"));
        verify(applicationConstantRepository).deleteById((String) any());
    }

    /**
     * Method under test: {@link ApplicationConstantService#findById(String)}
     */
    @Test
    void testFindById() {
        ApplicationConstant applicationConstant = new ApplicationConstant();
        applicationConstant.setCode("Code");
        applicationConstant.setLibelle("Libelle");
        applicationConstant.setNature("Nature");
        applicationConstant.setUesed(true);
        Optional<ApplicationConstant> ofResult = Optional.of(applicationConstant);
        when(applicationConstantRepository.findById((String) any())).thenReturn(ofResult);

        ApplicationConstantDto applicationConstantDto = new ApplicationConstantDto();
        applicationConstantDto.setCode("Code");
        applicationConstantDto.setCreateAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        applicationConstantDto.setId(123L);
        applicationConstantDto.setLastModifiedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        applicationConstantDto.setLibelle("Libelle");
        applicationConstantDto.setNature("Nature");
        applicationConstantDto.setUesed(true);
        when(applicationConstantMapper.toDto((ApplicationConstant) any())).thenReturn(applicationConstantDto);
        assertSame(applicationConstantDto, applicationConstantService.findById("42"));
        verify(applicationConstantRepository).findById((String) any());
        verify(applicationConstantMapper).toDto((ApplicationConstant) any());
    }

    /**
     * Method under test: {@link ApplicationConstantService#findById(String)}
     */
    @Test
    void testFindById2() {
        ApplicationConstant applicationConstant = new ApplicationConstant();
        applicationConstant.setCode("Code");
        applicationConstant.setLibelle("Libelle");
        applicationConstant.setNature("Nature");
        applicationConstant.setUesed(true);
        Optional<ApplicationConstant> ofResult = Optional.of(applicationConstant);
        when(applicationConstantRepository.findById((String) any())).thenReturn(ofResult);
        when(applicationConstantMapper.toDto((ApplicationConstant) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> applicationConstantService.findById("42"));
        verify(applicationConstantRepository).findById((String) any());
        verify(applicationConstantMapper).toDto((ApplicationConstant) any());
    }

    /**
     * Method under test: {@link ApplicationConstantService#findById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.data.rest.webmvc.ResourceNotFoundException: EntityRepresentationModel not found!
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at net.hypnozcore.hypnozcore.service.ApplicationConstantService.findById(ApplicationConstantService.java:36)
        //   In order to prevent findById(String)
        //   from throwing ResourceNotFoundException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findById(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(applicationConstantRepository.findById((String) any())).thenReturn(Optional.empty());

        ApplicationConstantDto applicationConstantDto = new ApplicationConstantDto();
        applicationConstantDto.setCode("Code");
        applicationConstantDto.setCreateAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        applicationConstantDto.setId(123L);
        applicationConstantDto.setLastModifiedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        applicationConstantDto.setLibelle("Libelle");
        applicationConstantDto.setNature("Nature");
        applicationConstantDto.setUesed(true);
        when(applicationConstantMapper.toDto((ApplicationConstant) any())).thenReturn(applicationConstantDto);
        applicationConstantService.findById("42");
    }

    /**
     * Method under test: {@link ApplicationConstantService#update(ApplicationConstantDto, String)}
     */
    @Test
    void testUpdate() {
        ApplicationConstantDto applicationConstantDto = new ApplicationConstantDto();
        applicationConstantDto.setCode("Code");
        applicationConstantDto.setCreateAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        applicationConstantDto.setId(123L);
        applicationConstantDto.setLastModifiedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        applicationConstantDto.setLibelle("Libelle");
        applicationConstantDto.setNature("Nature");
        applicationConstantDto.setUesed(true);
        ApplicationConstantDto actualUpdateResult = applicationConstantService.update(applicationConstantDto, "42");
        assertEquals("42", actualUpdateResult.getCode());
        assertTrue(actualUpdateResult.isUesed());
        assertEquals("Nature", actualUpdateResult.getNature());
        assertEquals("Libelle", actualUpdateResult.getLibelle());
    }

    /**
     * Method under test: {@link ApplicationConstantService#update(ApplicationConstantDto, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.data.rest.webmvc.ResourceNotFoundException: EntityRepresentationModel not found!
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at net.hypnozcore.hypnozcore.service.ApplicationConstantService.findById(ApplicationConstantService.java:36)
        //       at net.hypnozcore.hypnozcore.service.ApplicationConstantService.update(ApplicationConstantService.java:40)
        //       at net.hypnozcore.hypnozcore.service.ApplicationConstantService$$FastClassBySpringCGLIB$$fc432a0b.invoke(<generated>)
        //       at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
        //       at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:793)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
        //       at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:763)
        //       at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123)
        //       at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:388)
        //       at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:763)
        //       at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:708)
        //       at net.hypnozcore.hypnozcore.service.ApplicationConstantService$$EnhancerBySpringCGLIB$$30e91a07.update(<generated>)
        //   In order to prevent update(ApplicationConstantDto, String)
        //   from throwing ResourceNotFoundException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(ApplicationConstantDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ApplicationConstantDto applicationConstantDto = new ApplicationConstantDto();
        applicationConstantDto.setCode("Code");
        applicationConstantDto.setCreateAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        applicationConstantDto.setId(123L);
        applicationConstantDto.setLastModifiedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        applicationConstantDto.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        applicationConstantDto.setLibelle("Libelle");
        applicationConstantDto.setNature("Nature");
        applicationConstantDto.setUesed(true);
        applicationConstantService.update(applicationConstantDto,
                "update(Lnet/hypnozcore/hypnozcore/dto/ApplicationConstantDto;Ljava/lang/String;)Lnet/hypnozcore"
                        + "/hypnozcore/dto/ApplicationConstantDto;");
    }
}

