package net.hypnozcore.hypnozcore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.hypnozcore.hypnozcore.dto.Menus;
import net.hypnozcore.hypnozcore.dto.ModulesDto;
import net.hypnozcore.hypnozcore.dto.UsersDto;

import net.hypnozcore.hypnozcore.emus.Etats;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;
import net.hypnozcore.hypnozcore.mapper.ApplicationsMapper;
import net.hypnozcore.hypnozcore.mapper.FonctionsMapper;
import net.hypnozcore.hypnozcore.mapper.ModulesMapper;
import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.Structures;
import net.hypnozcore.hypnozcore.models.UserApplications;
import net.hypnozcore.hypnozcore.models.UserModules;
import net.hypnozcore.hypnozcore.models.Users;
import net.hypnozcore.hypnozcore.repository.ApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.FonctionsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.GroupesModulesRepository;
import net.hypnozcore.hypnozcore.repository.ModulesRepository;
import net.hypnozcore.hypnozcore.repository.ModulesStructureRepository;
import net.hypnozcore.hypnozcore.repository.StructuresRepository;
import net.hypnozcore.hypnozcore.repository.UserApplicationsRepository;
import net.hypnozcore.hypnozcore.repository.UserFonctionsRepository;
import net.hypnozcore.hypnozcore.repository.UserModulesRepository;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class GenerateMenuServiceTest {
    @MockBean
    private ApplicationsMapper applicationsMapper;

    @MockBean
    private ApplicationsRepository applicationsRepository;

    @MockBean
    private FonctionsMapper fonctionsMapper;

    @MockBean
    private FonctionsRepository fonctionsRepository;

    @MockBean
    private GroupesApplicationsRepository groupesApplicationsRepository;

    @MockBean
    private GroupesFonctionsRepository groupesFonctionsRepository;

    @MockBean
    private GroupesModulesRepository groupesModulesRepository;

    @MockBean
    private ModulesMapper modulesMapper;

    @MockBean
    private ModulesRepository modulesRepository;

    @MockBean
    private ModulesStructureRepository modulesStructureRepository;

    @MockBean
    private StructuresRepository structuresRepository;

    @MockBean
    private UserApplicationsRepository userApplicationsRepository;

    @MockBean
    private UserFonctionsRepository userFonctionsRepository;

    @MockBean
    private UserModulesRepository userModulesRepository;

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
        //       at jdk.proxy4.$Proxy192.saveAndFlush(null)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.lambda$createDefaultModule$0(GenerateMenuService.java:99)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
        //       at java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
        //       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
        //       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
        //       at java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.createDefaultModule(GenerateMenuService.java:103)
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
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService$$EnhancerBySpringCGLIB$$6f70f380.createDefaultModule(<generated>)
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
        //       at jdk.proxy4.$Proxy192.saveAndFlush(null)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.lambda$createDefaultModule$0(GenerateMenuService.java:99)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
        //       at java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
        //       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
        //       at java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
        //       at java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.createDefaultModule(GenerateMenuService.java:103)
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
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService$$EnhancerBySpringCGLIB$$6f70f380.createDefaultModule(<generated>)
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
        Modules modules = new Modules();
        modules.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Applications applications = new Applications();
        applications.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setFlagEtat(Etats.INACTIVE);
        applications.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setId(123L);
        applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setModule("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setModules(modules);
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
        Modules modules = new Modules();
        modules.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Applications applications = new Applications();
        applications.setActive("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setFlagEtat(Etats.INACTIVE);
        applications.setIconClass("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setId(123L);
        applications.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        applications.setLibCode("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setLibDesc("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setModule("createDefaultFonctions(Ljava/util/List;)Ljava/util/List;");
        applications.setModules(modules);
        applications.setOrdre(1);
        applications.setUrl("https://example.org/example");

        Modules modules1 = new Modules();
        modules1.setActive("config/fonctions.json");
        modules1.setCode("config/fonctions.json");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("config/fonctions.json");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("config/fonctions.json");
        modules1.setLibDesc("config/fonctions.json");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Applications applications1 = new Applications();
        applications1.setActive("config/fonctions.json");
        applications1.setCode("config/fonctions.json");
        applications1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        applications1.setFlagEtat(Etats.INACTIVE);
        applications1.setIconClass("config/fonctions.json");
        applications1.setId(123L);
        applications1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        applications1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        applications1.setLibCode("config/fonctions.json");
        applications1.setLibDesc("config/fonctions.json");
        applications1.setModule("config/fonctions.json");
        applications1.setModules(modules1);
        applications1.setOrdre(1);
        applications1.setUrl("https://example.org/example");

        ArrayList<Applications> applicationsList = new ArrayList<>();
        applicationsList.add(applications1);
        applicationsList.add(applications);
        assertTrue(generateMenuService.createDefaultFonctions(applicationsList).isEmpty());
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles() {
        ArrayList<UserModules> userModulesList = new ArrayList<>();
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuService.getRoles(usersDto, modulesDto);
        assertEquals(userModulesList, actualRoles.getBody());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles2() {
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenThrow(new ResponseException("An error occurred"));
        assertThrows(ResponseException.class, () -> generateMenuService.getRoles(usersDto, modulesDto));
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles3() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuService.getRoles(usersDto, modulesDto);
        assertTrue(actualRoles.hasBody());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles4() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Y");
        modules1.setCode("Y");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Y");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Y");
        modules1.setLibDesc("Y");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Users users1 = new Users();
        users1.setAdresse("Y");
        users1.setBp("Y");
        users1.setCel("Y");
        users1.setCivilite("Y");
        users1.setCodeSecret("Y");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setEtat(true);
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Y");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Y");
        users1.setNom("Y");
        users1.setPatronyme("Y");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Y");
        users1.setPwd("Y");
        users1.setSignature("Y");
        users1.setTelBureau("Y");
        users1.setTelDomicile("Y");
        users1.setVille("Y");

        UserModules userModules1 = new UserModules();
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules1);
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        ArrayList<UserApplications> userApplicationsList = new ArrayList<>();
        when(userApplicationsRepository.findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any()))
                .thenReturn(userApplicationsList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuService.getRoles(usersDto, modulesDto);
        List<Menus> body = actualRoles.getBody();
        assertEquals(userApplicationsList, body);
        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(userApplicationsRepository).findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles5() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Y");
        modules1.setCode("Y");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Y");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Y");
        modules1.setLibDesc("Y");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Users users1 = new Users();
        users1.setAdresse("Y");
        users1.setBp("Y");
        users1.setCel("Y");
        users1.setCivilite("Y");
        users1.setCodeSecret("Y");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setEtat(true);
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Y");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Y");
        users1.setNom("Y");
        users1.setPatronyme("Y");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Y");
        users1.setPwd("Y");
        users1.setSignature("Y");
        users1.setTelBureau("Y");
        users1.setTelDomicile("Y");
        users1.setVille("Y");

        Modules modules2 = new Modules();
        modules2.setActive("Active");
        modules2.setCode("Code");
        modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setFlagEtat(Etats.INACTIVE);
        modules2.setIconClass("Icon Class");
        modules2.setId(123L);
        modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setLibCode("Lib Code");
        modules2.setLibDesc("Lib Desc");
        modules2.setOrdre(1);
        modules2.setStandart(1);
        modules2.setUrl("https://example.org/example");
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getModules()).thenReturn(modules2);
        doNothing().when(userModules1).setId((UserModules.UserModulesPK) any());
        doNothing().when(userModules1).setModules((Modules) any());
        doNothing().when(userModules1).setNew(anyBoolean());
        doNothing().when(userModules1).setUsers((Users) any());
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules1);
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        ArrayList<UserApplications> userApplicationsList = new ArrayList<>();
        when(userApplicationsRepository.findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any()))
                .thenReturn(userApplicationsList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuService.getRoles(usersDto, modulesDto);
        assertEquals(userApplicationsList, actualRoles.getBody());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(userModules1).getModules();
        verify(userModules1).setId((UserModules.UserModulesPK) any());
        verify(userModules1).setModules((Modules) any());
        verify(userModules1).setNew(anyBoolean());
        verify(userModules1).setUsers((Users) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles6() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Y");
        modules1.setCode("Y");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Y");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Y");
        modules1.setLibDesc("Y");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Users users1 = new Users();
        users1.setAdresse("Y");
        users1.setBp("Y");
        users1.setCel("Y");
        users1.setCivilite("Y");
        users1.setCodeSecret("Y");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setEtat(true);
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Y");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Y");
        users1.setNom("Y");
        users1.setPatronyme("Y");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Y");
        users1.setPwd("Y");
        users1.setSignature("Y");
        users1.setTelBureau("Y");
        users1.setTelDomicile("Y");
        users1.setVille("Y");
        Modules modules2 = mock(Modules.class);
        when(modules2.getActive()).thenReturn("Y");
        doNothing().when(modules2).setCreatedBy((String) any());
        doNothing().when(modules2).setCreatedDate((Date) any());
        doNothing().when(modules2).setFlagEtat((Etats) any());
        doNothing().when(modules2).setId((Long) any());
        doNothing().when(modules2).setLastModifiedBy((String) any());
        doNothing().when(modules2).setLastModifiedDate((Date) any());
        doNothing().when(modules2).setActive((String) any());
        doNothing().when(modules2).setCode((String) any());
        doNothing().when(modules2).setIconClass((String) any());
        doNothing().when(modules2).setLibCode((String) any());
        doNothing().when(modules2).setLibDesc((String) any());
        doNothing().when(modules2).setOrdre(anyInt());
        doNothing().when(modules2).setStandart(anyInt());
        doNothing().when(modules2).setUrl((String) any());
        modules2.setActive("Active");
        modules2.setCode("Code");
        modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setFlagEtat(Etats.INACTIVE);
        modules2.setIconClass("Icon Class");
        modules2.setId(123L);
        modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setLibCode("Lib Code");
        modules2.setLibDesc("Lib Desc");
        modules2.setOrdre(1);
        modules2.setStandart(1);
        modules2.setUrl("https://example.org/example");

        UserModules.UserModulesPK userModulesPK2 = new UserModules.UserModulesPK();
        userModulesPK2.setModulesId(123L);
        userModulesPK2.setUsersId(123L);
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getId()).thenReturn(userModulesPK2);
        when(userModules1.getModules()).thenReturn(modules2);
        doNothing().when(userModules1).setId((UserModules.UserModulesPK) any());
        doNothing().when(userModules1).setModules((Modules) any());
        doNothing().when(userModules1).setNew(anyBoolean());
        doNothing().when(userModules1).setUsers((Users) any());
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules1);
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        ArrayList<UserApplications> userApplicationsList = new ArrayList<>();
        when(userApplicationsRepository.findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any()))
                .thenReturn(userApplicationsList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuService.getRoles(usersDto, modulesDto);
        List<Menus> body = actualRoles.getBody();
        assertEquals(userApplicationsList, body);
        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(userModules1).getModules();
        verify(userModules1, atLeast(1)).getId();
        verify(userModules1).setId((UserModules.UserModulesPK) any());
        verify(userModules1).setModules((Modules) any());
        verify(userModules1).setNew(anyBoolean());
        verify(userModules1).setUsers((Users) any());
        verify(modules2).getActive();
        verify(modules2).setCreatedBy((String) any());
        verify(modules2).setCreatedDate((Date) any());
        verify(modules2).setFlagEtat((Etats) any());
        verify(modules2).setId((Long) any());
        verify(modules2).setLastModifiedBy((String) any());
        verify(modules2).setLastModifiedDate((Date) any());
        verify(modules2).setActive((String) any());
        verify(modules2).setCode((String) any());
        verify(modules2).setIconClass((String) any());
        verify(modules2).setLibCode((String) any());
        verify(modules2).setLibDesc((String) any());
        verify(modules2).setOrdre(anyInt());
        verify(modules2).setStandart(anyInt());
        verify(modules2).setUrl((String) any());
        verify(userApplicationsRepository).findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles7() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Y");
        modules1.setCode("Y");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Y");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Y");
        modules1.setLibDesc("Y");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Users users1 = new Users();
        users1.setAdresse("Y");
        users1.setBp("Y");
        users1.setCel("Y");
        users1.setCivilite("Y");
        users1.setCodeSecret("Y");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setEtat(true);
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Y");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Y");
        users1.setNom("Y");
        users1.setPatronyme("Y");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Y");
        users1.setPwd("Y");
        users1.setSignature("Y");
        users1.setTelBureau("Y");
        users1.setTelDomicile("Y");
        users1.setVille("Y");
        Modules modules2 = mock(Modules.class);
        when(modules2.getActive()).thenReturn("Y");
        doNothing().when(modules2).setCreatedBy((String) any());
        doNothing().when(modules2).setCreatedDate((Date) any());
        doNothing().when(modules2).setFlagEtat((Etats) any());
        doNothing().when(modules2).setId((Long) any());
        doNothing().when(modules2).setLastModifiedBy((String) any());
        doNothing().when(modules2).setLastModifiedDate((Date) any());
        doNothing().when(modules2).setActive((String) any());
        doNothing().when(modules2).setCode((String) any());
        doNothing().when(modules2).setIconClass((String) any());
        doNothing().when(modules2).setLibCode((String) any());
        doNothing().when(modules2).setLibDesc((String) any());
        doNothing().when(modules2).setOrdre(anyInt());
        doNothing().when(modules2).setStandart(anyInt());
        doNothing().when(modules2).setUrl((String) any());
        modules2.setActive("Active");
        modules2.setCode("Code");
        modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setFlagEtat(Etats.INACTIVE);
        modules2.setIconClass("Icon Class");
        modules2.setId(123L);
        modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setLibCode("Lib Code");
        modules2.setLibDesc("Lib Desc");
        modules2.setOrdre(1);
        modules2.setStandart(1);
        modules2.setUrl("https://example.org/example");

        UserModules.UserModulesPK userModulesPK2 = new UserModules.UserModulesPK();
        userModulesPK2.setModulesId(null);
        userModulesPK2.setUsersId(123L);
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getId()).thenReturn(userModulesPK2);
        when(userModules1.getModules()).thenReturn(modules2);
        doNothing().when(userModules1).setId((UserModules.UserModulesPK) any());
        doNothing().when(userModules1).setModules((Modules) any());
        doNothing().when(userModules1).setNew(anyBoolean());
        doNothing().when(userModules1).setUsers((Users) any());
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules1);
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        ArrayList<UserApplications> userApplicationsList = new ArrayList<>();
        when(userApplicationsRepository.findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any()))
                .thenReturn(userApplicationsList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuService.getRoles(usersDto, modulesDto);
        List<Menus> body = actualRoles.getBody();
        assertEquals(userApplicationsList, body);
        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(userModules1).getModules();
        verify(userModules1, atLeast(1)).getId();
        verify(userModules1).setId((UserModules.UserModulesPK) any());
        verify(userModules1).setModules((Modules) any());
        verify(userModules1).setNew(anyBoolean());
        verify(userModules1).setUsers((Users) any());
        verify(modules2).getActive();
        verify(modules2).setCreatedBy((String) any());
        verify(modules2).setCreatedDate((Date) any());
        verify(modules2).setFlagEtat((Etats) any());
        verify(modules2).setId((Long) any());
        verify(modules2).setLastModifiedBy((String) any());
        verify(modules2).setLastModifiedDate((Date) any());
        verify(modules2).setActive((String) any());
        verify(modules2).setCode((String) any());
        verify(modules2).setIconClass((String) any());
        verify(modules2).setLibCode((String) any());
        verify(modules2).setLibDesc((String) any());
        verify(modules2).setOrdre(anyInt());
        verify(modules2).setStandart(anyInt());
        verify(modules2).setUrl((String) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    void testGetRoles8() {
        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Y");
        modules1.setCode("Y");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Y");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Y");
        modules1.setLibDesc("Y");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Users users1 = new Users();
        users1.setAdresse("Y");
        users1.setBp("Y");
        users1.setCel("Y");
        users1.setCivilite("Y");
        users1.setCodeSecret("Y");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setEtat(true);
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Y");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Y");
        users1.setNom("Y");
        users1.setPatronyme("Y");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Y");
        users1.setPwd("Y");
        users1.setSignature("Y");
        users1.setTelBureau("Y");
        users1.setTelDomicile("Y");
        users1.setVille("Y");
        Modules modules2 = mock(Modules.class);
        when(modules2.getActive()).thenReturn("Y");
        doNothing().when(modules2).setCreatedBy((String) any());
        doNothing().when(modules2).setCreatedDate((Date) any());
        doNothing().when(modules2).setFlagEtat((Etats) any());
        doNothing().when(modules2).setId((Long) any());
        doNothing().when(modules2).setLastModifiedBy((String) any());
        doNothing().when(modules2).setLastModifiedDate((Date) any());
        doNothing().when(modules2).setActive((String) any());
        doNothing().when(modules2).setCode((String) any());
        doNothing().when(modules2).setIconClass((String) any());
        doNothing().when(modules2).setLibCode((String) any());
        doNothing().when(modules2).setLibDesc((String) any());
        doNothing().when(modules2).setOrdre(anyInt());
        doNothing().when(modules2).setStandart(anyInt());
        doNothing().when(modules2).setUrl((String) any());
        modules2.setActive("Active");
        modules2.setCode("Code");
        modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setFlagEtat(Etats.INACTIVE);
        modules2.setIconClass("Icon Class");
        modules2.setId(123L);
        modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setLibCode("Lib Code");
        modules2.setLibDesc("Lib Desc");
        modules2.setOrdre(1);
        modules2.setStandart(1);
        modules2.setUrl("https://example.org/example");

        UserModules.UserModulesPK userModulesPK2 = new UserModules.UserModulesPK();
        userModulesPK2.setModulesId(123L);
        userModulesPK2.setUsersId(null);
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getId()).thenReturn(userModulesPK2);
        when(userModules1.getModules()).thenReturn(modules2);
        doNothing().when(userModules1).setId((UserModules.UserModulesPK) any());
        doNothing().when(userModules1).setModules((Modules) any());
        doNothing().when(userModules1).setNew(anyBoolean());
        doNothing().when(userModules1).setUsers((Users) any());
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules1);
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        ArrayList<UserApplications> userApplicationsList = new ArrayList<>();
        when(userApplicationsRepository.findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any()))
                .thenReturn(userApplicationsList);
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        ResponseEntity<List<Menus>> actualRoles = generateMenuService.getRoles(usersDto, modulesDto);
        List<Menus> body = actualRoles.getBody();
        assertEquals(userApplicationsList, body);
        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, actualRoles.getStatusCode());
        assertTrue(actualRoles.getHeaders().isEmpty());
        verify(userModulesRepository).findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any());
        verify(userModules1).getModules();
        verify(userModules1, atLeast(1)).getId();
        verify(userModules1).setId((UserModules.UserModulesPK) any());
        verify(userModules1).setModules((Modules) any());
        verify(userModules1).setNew(anyBoolean());
        verify(userModules1).setUsers((Users) any());
        verify(modules2).getActive();
        verify(modules2).setCreatedBy((String) any());
        verify(modules2).setCreatedDate((Date) any());
        verify(modules2).setFlagEtat((Etats) any());
        verify(modules2).setId((Long) any());
        verify(modules2).setLastModifiedBy((String) any());
        verify(modules2).setLastModifiedDate((Date) any());
        verify(modules2).setActive((String) any());
        verify(modules2).setCode((String) any());
        verify(modules2).setIconClass((String) any());
        verify(modules2).setLibCode((String) any());
        verify(modules2).setLibDesc((String) any());
        verify(modules2).setOrdre(anyInt());
        verify(modules2).setStandart(anyInt());
        verify(modules2).setUrl((String) any());
        verify(usersDto).getId();
        verify(modulesDto).getId();
    }

    /**
     * Method under test: {@link GenerateMenuService#getRoles(UsersDto, ModulesDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetRoles9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at net.hypnozcore.hypnozcore.service.GenerateMenuService.getRoles(GenerateMenuService.java:173)
        //   In order to prevent getRoles(UsersDto, ModulesDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getRoles(UsersDto, ModulesDto).
        //   See https://diff.blue/R013 to resolve this issue.

        UserModules.UserModulesPK userModulesPK = new UserModules.UserModulesPK();
        userModulesPK.setModulesId(123L);
        userModulesPK.setUsersId(123L);

        Modules modules = new Modules();
        modules.setActive("Active");
        modules.setCode("Code");
        modules.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setFlagEtat(Etats.INACTIVE);
        modules.setIconClass("Icon Class");
        modules.setId(123L);
        modules.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        modules.setLibCode("Lib Code");
        modules.setLibDesc("Lib Desc");
        modules.setOrdre(1);
        modules.setStandart(1);
        modules.setUrl("https://example.org/example");

        Users users = new Users();
        users.setAdresse("Adresse");
        users.setBp("Bp");
        users.setCel("Cel");
        users.setCivilite("Civilite");
        users.setCodeSecret("Code Secret");
        users.setConnexion(1);
        users.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        users.setDateNaissance(LocalDate.ofEpochDay(1L));
        users.setEtat(true);
        users.setFirstLog(LocalDate.ofEpochDay(1L));
        users.setFlagEtat(Etats.INACTIVE);
        users.setId(123L);
        users.setLangue("Langue");
        users.setLastLog(LocalDate.ofEpochDay(1L));
        users.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users.setLastModifiedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        users.setLogin("Login");
        users.setNom("Nom");
        users.setPatronyme("Patronyme");
        users.setPhoto("alice.liddell@example.org");
        users.setPrenom("Prenom");
        users.setPwd("Pwd");
        users.setSignature("Signature");
        users.setTelBureau("Tel Bureau");
        users.setTelDomicile("Tel Domicile");
        users.setVille("Ville");

        UserModules userModules = new UserModules();
        userModules.setId(userModulesPK);
        userModules.setModules(modules);
        userModules.setNew(true);
        userModules.setUsers(users);

        UserModules.UserModulesPK userModulesPK1 = new UserModules.UserModulesPK();
        userModulesPK1.setModulesId(123L);
        userModulesPK1.setUsersId(123L);

        Modules modules1 = new Modules();
        modules1.setActive("Y");
        modules1.setCode("Y");
        modules1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setCreatedDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setFlagEtat(Etats.INACTIVE);
        modules1.setIconClass("Y");
        modules1.setId(123L);
        modules1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        modules1.setLibCode("Y");
        modules1.setLibDesc("Y");
        modules1.setOrdre(1);
        modules1.setStandart(1);
        modules1.setUrl("https://example.org/example");

        Users users1 = new Users();
        users1.setAdresse("Y");
        users1.setBp("Y");
        users1.setCel("Y");
        users1.setCivilite("Y");
        users1.setCodeSecret("Y");
        users1.setConnexion(1);
        users1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setCreatedDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setDateNaissance(LocalDate.ofEpochDay(1L));
        users1.setEtat(true);
        users1.setFirstLog(LocalDate.ofEpochDay(1L));
        users1.setFlagEtat(Etats.INACTIVE);
        users1.setId(123L);
        users1.setLangue("Y");
        users1.setLastLog(LocalDate.ofEpochDay(1L));
        users1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        users1.setLastModifiedDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        users1.setLogin("Y");
        users1.setNom("Y");
        users1.setPatronyme("Y");
        users1.setPhoto("alice.liddell@example.org");
        users1.setPrenom("Y");
        users1.setPwd("Y");
        users1.setSignature("Y");
        users1.setTelBureau("Y");
        users1.setTelDomicile("Y");
        users1.setVille("Y");
        Modules modules2 = mock(Modules.class);
        when(modules2.getActive()).thenReturn(null);
        doNothing().when(modules2).setCreatedBy((String) any());
        doNothing().when(modules2).setCreatedDate((Date) any());
        doNothing().when(modules2).setFlagEtat((Etats) any());
        doNothing().when(modules2).setId((Long) any());
        doNothing().when(modules2).setLastModifiedBy((String) any());
        doNothing().when(modules2).setLastModifiedDate((Date) any());
        doNothing().when(modules2).setActive((String) any());
        doNothing().when(modules2).setCode((String) any());
        doNothing().when(modules2).setIconClass((String) any());
        doNothing().when(modules2).setLibCode((String) any());
        doNothing().when(modules2).setLibDesc((String) any());
        doNothing().when(modules2).setOrdre(anyInt());
        doNothing().when(modules2).setStandart(anyInt());
        doNothing().when(modules2).setUrl((String) any());
        modules2.setActive("Active");
        modules2.setCode("Code");
        modules2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setCreatedDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setFlagEtat(Etats.INACTIVE);
        modules2.setIconClass("Icon Class");
        modules2.setId(123L);
        modules2.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        modules2.setLastModifiedDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        modules2.setLibCode("Lib Code");
        modules2.setLibDesc("Lib Desc");
        modules2.setOrdre(1);
        modules2.setStandart(1);
        modules2.setUrl("https://example.org/example");

        UserModules.UserModulesPK userModulesPK2 = new UserModules.UserModulesPK();
        userModulesPK2.setModulesId(123L);
        userModulesPK2.setUsersId(123L);
        UserModules userModules1 = mock(UserModules.class);
        when(userModules1.getId()).thenReturn(userModulesPK2);
        when(userModules1.getModules()).thenReturn(modules2);
        doNothing().when(userModules1).setId((UserModules.UserModulesPK) any());
        doNothing().when(userModules1).setModules((Modules) any());
        doNothing().when(userModules1).setNew(anyBoolean());
        doNothing().when(userModules1).setUsers((Users) any());
        userModules1.setId(userModulesPK1);
        userModules1.setModules(modules1);
        userModules1.setNew(true);
        userModules1.setUsers(users1);

        ArrayList<UserModules> userModulesList = new ArrayList<>();
        userModulesList.add(userModules1);
        userModulesList.add(userModules);
        when(userModulesRepository.findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc((Long) any(), (Long) any()))
                .thenReturn(userModulesList);
        when(userApplicationsRepository.findByIdUsersIdAndApplicationsModulesId((Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        UsersDto usersDto = mock(UsersDto.class);
        when(usersDto.getId()).thenReturn(123L);
        ModulesDto modulesDto = mock(ModulesDto.class);
        when(modulesDto.getId()).thenReturn(123L);
        generateMenuService.getRoles(usersDto, modulesDto);
    }

    /**
     * Method under test: {@link GenerateMenuService#deleteFonctionByGroupe(Long, Long)}
     */
    @Test
    void testDeleteFonctionByGroupe() {
        assertThrows(ResponseException.class, () -> generateMenuService.deleteFonctionByGroupe(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuService.deleteFonctionByGroupe(2L, 1L));
    }

    /**
     * Method under test: {@link GenerateMenuService#deleteGroupeApplication(long, long)}
     */
    @Test
    void testDeleteGroupeApplication() {
        assertThrows(ResponseException.class, () -> generateMenuService.deleteGroupeApplication(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuService.deleteGroupeApplication(2L, 1L));
    }

    /**
     * Method under test: {@link GenerateMenuService#deleteGroupeModule(Long, Long)}
     */
    @Test
    void testDeleteGroupeModule() {
        assertThrows(ResponseException.class, () -> generateMenuService.deleteGroupeModule(1L, 1L));
        assertThrows(ResponseException.class, () -> generateMenuService.deleteGroupeModule(2L, 1L));
    }

    /**
     * Method under test: {@link GenerateMenuService#deleteUserFonction(Long, Long)}
     */
    @Test
    void testDeleteUserFonction() {
        assertThrows(ResponseException.class, () -> generateMenuService.deleteUserFonction(123L, 123L));
    }

    /**
     * Method under test: {@link GenerateMenuService#deleteUserApplication(Long, Long)}
     */
    @Test
    void testDeleteUserApplication() {
        assertThrows(ResponseException.class, () -> generateMenuService.deleteUserApplication(123L, 123L));
    }

    /**
     * Method under test: {@link GenerateMenuService#deleteUserModules(Long, Long)}
     */
    @Test
    void testDeleteUserModules() {
        assertThrows(ResponseException.class, () -> generateMenuService.deleteUserModules(123L, 123L));
    }
}

