package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class GenerateMenuServiceTest {
    @Autowired
    private GenerateMenuService generateMenuService;

    /**
     * Method under test: {@link GenerateMenuService#createDefaultModule(Structures)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateDefaultModule() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.orm.jpa.JpaSystemException: attempted to assign id from null one-to-one property [net.hypnozcore.hypnozcore.models.ModulesStructure.structures]; nested exception is org.hibernate.id.IdentifierGenerationException: attempted to assign id from null one-to-one property [net.hypnozcore.hypnozcore.models.ModulesStructure.structures]
        //       at org.springframework.orm.jpa.vendor.HibernateJpaDialect.convertHibernateAccessException(HibernateJpaDialect.java:331)
        //       at org.springframework.orm.jpa.vendor.HibernateJpaDialect.translateExceptionIfPossible(HibernateJpaDialect.java:233)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.translateExceptionIfPossible(AbstractEntityManagerFactoryBean.java:551)
        //       at org.springframework.dao.support.ChainedPersistenceExceptionTranslator.translateExceptionIfPossible(ChainedPersistenceExceptionTranslator.java:61)
        //       at org.springframework.dao.support.DataAccessUtils.translateIfNecessary(DataAccessUtils.java:242)
        //       at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:152)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.data.jpa.repository.support.CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor.invoke(CrudMethodMetadataPostProcessor.java:174)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:215)
        //       at jdk.proxy4.$Proxy191.saveAndFlush(null)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.lambda$createDefaultModule$0(GenerateMenuService.java:80)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
        //       at java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
        //       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
        //       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
        //       at java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.createDefaultModule(GenerateMenuService.java:84)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService$$FastClassBySpringCGLIB$$965de7d7.invoke(<generated>)
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
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService$$EnhancerBySpringCGLIB$$f4995523.createDefaultModule(<generated>)
        //   In order to prevent createDefaultModule(Structures)
        //   from throwing JpaSystemException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createDefaultModule(Structures).
        //   See https://diff.blue/R013 to resolve this issue.

        Structures structures = new Structures();
        structures.setActiviteCommerciale("Activite Commerciale");
        structures.setAdresse("Adresse");
        structures.setBilanSocail("Bilan Socail");
        structures.setCapital("Capital");
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures.setDepartement("Departement");
        structures.setDescription("The characteristics of someone or something");
        structures.setEmail("jane.doe@example.org");
        structures.setFlagEtat(Etats.INACTIVE);
        structures.setFormJuridique("Form Juridique");
        structures.setId(123L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setLogo("Logo");
        structures.setPays("Pays");
        structures.setQualiteResponsable("Qualite Responsable");
        structures.setRaisonSocial("Raison Social");
        structures.setResponsable("Responsable");
        structures.setSigle("Sigle");
        structures.setSiteweb("Siteweb");
        structures.setTelephone("4105551212");
        structures.setTypeEntreprise(TypeEntreprise.SA);
        structures.setVille("Ville");
        structures.setZoneFiscale("Zone Fiscale");
        structures.setZoneFiscale2("Zone Fiscale2");
        generateMenuService.createDefaultModule(structures);
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultModule(Structures)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateDefaultModule2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.orm.jpa.JpaSystemException: attempted to assign id from null one-to-one property [net.hypnozcore.hypnozcore.models.ModulesStructure.structures]; nested exception is org.hibernate.id.IdentifierGenerationException: attempted to assign id from null one-to-one property [net.hypnozcore.hypnozcore.models.ModulesStructure.structures]
        //       at org.springframework.orm.jpa.vendor.HibernateJpaDialect.convertHibernateAccessException(HibernateJpaDialect.java:331)
        //       at org.springframework.orm.jpa.vendor.HibernateJpaDialect.translateExceptionIfPossible(HibernateJpaDialect.java:233)
        //       at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.translateExceptionIfPossible(AbstractEntityManagerFactoryBean.java:551)
        //       at org.springframework.dao.support.ChainedPersistenceExceptionTranslator.translateExceptionIfPossible(ChainedPersistenceExceptionTranslator.java:61)
        //       at org.springframework.dao.support.DataAccessUtils.translateIfNecessary(DataAccessUtils.java:242)
        //       at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:152)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.data.jpa.repository.support.CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor.invoke(CrudMethodMetadataPostProcessor.java:174)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
        //       at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        //       at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:215)
        //       at jdk.proxy4.$Proxy191.saveAndFlush(null)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.lambda$createDefaultModule$0(GenerateMenuService.java:80)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
        //       at java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
        //       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
        //       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
        //       at java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.createDefaultModule(GenerateMenuService.java:84)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService$$FastClassBySpringCGLIB$$965de7d7.invoke(<generated>)
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
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService$$EnhancerBySpringCGLIB$$f4995523.createDefaultModule(<generated>)
        //   In order to prevent createDefaultModule(Structures)
        //   from throwing JpaSystemException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createDefaultModule(Structures).
        //   See https://diff.blue/R013 to resolve this issue.

        Structures structures = new Structures();
        structures.setActiviteCommerciale("l.UlUlUlUlUl.U");
        structures.setAdresse("Adresse");
        structures.setBilanSocail("Bilan Socail");
        structures.setCapital("Capital");
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures.setDepartement("Departement");
        structures.setDescription("The characteristics of someone or something");
        structures.setEmail("jane.doe@example.org");
        structures.setFlagEtat(Etats.INACTIVE);
        structures.setFormJuridique("Form Juridique");
        structures.setId(123L);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setLogo("Logo");
        structures.setPays("Pays");
        structures.setQualiteResponsable("Qualite Responsable");
        structures.setRaisonSocial("Raison Social");
        structures.setResponsable("Responsable");
        structures.setSigle("Sigle");
        structures.setSiteweb("Siteweb");
        structures.setTelephone("4105551212");
        structures.setTypeEntreprise(TypeEntreprise.SA);
        structures.setVille("Ville");
        structures.setZoneFiscale("Zone Fiscale");
        structures.setZoneFiscale2("Zone Fiscale2");
        generateMenuService.createDefaultModule(structures);
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultModule(Structures)}
     */
    @Test
    void testCreateDefaultModule3() {
        Structures structures = new Structures();
        structures.setActiviteCommerciale("Activite Commerciale");
        structures.setAdresse("Adresse");
        structures.setBilanSocail("Bilan Socail");
        structures.setCapital("Capital");
        structures.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setDateFiscale(LocalDate.ofEpochDay(1L));
        structures.setDepartement("Departement");
        structures.setDescription("The characteristics of someone or something");
        structures.setEmail("jane.doe@example.org");
        structures.setFlagEtat(Etats.INACTIVE);
        structures.setFormJuridique("Form Juridique");
        structures.setId(null);
        structures.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        structures.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        structures.setLogo("Logo");
        structures.setPays("Pays");
        structures.setQualiteResponsable("Qualite Responsable");
        structures.setRaisonSocial("Raison Social");
        structures.setResponsable("Responsable");
        structures.setSigle("Sigle");
        structures.setSiteweb("Siteweb");
        structures.setTelephone("4105551212");
        structures.setTypeEntreprise(TypeEntreprise.SA);
        structures.setVille("Ville");
        structures.setZoneFiscale("Zone Fiscale");
        structures.setZoneFiscale2("Zone Fiscale2");
        assertThrows(ResponseException.class, () -> generateMenuService.createDefaultModule(structures));
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultApplication(List)}
     */
    @Test
    void testCreateDefaultApplication() {
        assertTrue(generateMenuService.createDefaultApplication(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultApplication(List)}
     */
    @Test
    void testCreateDefaultApplication2() {
        Modules modules = new Modules();
        modules.setActive("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        ArrayList<Modules> modulesList = new ArrayList<>();
        modulesList.add(modules);
        assertTrue(generateMenuService.createDefaultApplication(modulesList).isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultApplication(List)}
     */
    @Test
    void testCreateDefaultApplication3() {
        Modules modules = new Modules();
        modules.setActive("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Modules modules1 = new Modules();
        modules1.setActive("config/Applications.json");
        modules1.setCode("config/Applications.json");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("config/Applications.json");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("config/Applications.json");
        modules1.setLibDesc("config/Applications.json");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        ArrayList<Modules> modulesList = new ArrayList<>();
        modulesList.add(modules1);
        modulesList.add(modules);
        assertTrue(generateMenuService.createDefaultApplication(modulesList).isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultApplication(List)}
     */
    @Test
    void testCreateDefaultApplication4() {
        Modules modules = new Modules();
        modules.setActive("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("M0");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        ArrayList<Modules> modulesList = new ArrayList<>();
        modulesList.add(modules);
        assertEquals(3, generateMenuService.createDefaultApplication(modulesList).size());
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultApplication(List)}
     */
    @Test
    void testCreateDefaultApplication5() {
        Modules modules = new Modules();
        modules.setActive("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultApplication(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Modules modules1 = new Modules();
        modules1.setActive("config/Applications.json");
        modules1.setCode("M0");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("config/Applications.json");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("config/Applications.json");
        modules1.setLibDesc("config/Applications.json");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        ArrayList<Modules> modulesList = new ArrayList<>();
        modulesList.add(modules1);
        modulesList.add(modules);
        assertEquals(3, generateMenuService.createDefaultApplication(modulesList).size());
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultFonctions(List)}
     */
    @Test
    void testCreateDefaultFonctions() {
        assertTrue(generateMenuService.createDefaultFonctions(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultFonctions(List)}
     */
    @Test
    void testCreateDefaultFonctions2() {
        Applications applications = new Applications();
        applications.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setFlagEtat(Etats.INACTIVE);
        applications.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setId(123L);
        applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setModule("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setModulesId(123L);
        applications.setOrdre(1);
        applications.setUrl("https://example.org/example");

        ArrayList<Applications> applicationsList = new ArrayList<>();
        applicationsList.add(applications);
        assertTrue(generateMenuService.createDefaultFonctions(applicationsList).isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuService#createDefaultFonctions(List)}
     */
    @Test
    void testCreateDefaultFonctions3() {
        Applications applications = new Applications();
        applications.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setFlagEtat(Etats.INACTIVE);
        applications.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setId(123L);
        applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setModule("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setModulesId(123L);
        applications.setOrdre(1);
        applications.setUrl("https://example.org/example");

        Applications applications1 = new Applications();
        applications1.setActive("config/fonctions.json");
        applications1.setCode("config/fonctions.json");
        applications1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications1.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        applications1.setFlagEtat(Etats.INACTIVE);
        applications1.setIconClass("config/fonctions.json");
        applications1.setId(123L);
        applications1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications1.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        applications1.setLibCode("config/fonctions.json");
        applications1.setLibDesc("config/fonctions.json");
        applications1.setModule("config/fonctions.json");
        applications1.setModulesId(123L);
        applications1.setOrdre(1);
        applications1.setUrl("https://example.org/example");

        ArrayList<Applications> applicationsList = new ArrayList<>();
        applicationsList.add(applications1);
        applicationsList.add(applications);
        assertTrue(generateMenuService.createDefaultFonctions(applicationsList).isEmpty());
    }
}

