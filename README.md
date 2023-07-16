# Web Ve API Test Projesi

Projenin amacı, API çağrıları ve bir web sitesinin işlevselliği için bir test çerçevesi oluşturmaktır. Bu çerçeveyi oluşturarak, diğer testçilerin bizim çerçevemizi kullanarak siteyi verimli bir şekilde test etmelerine yardımcı olmak istiyoruz. Web sitesini ve otomasyon testini uygulamak için oluşturulmuş bir site olan <https://automationexercise.com/> API'sini test ettik. Proje iki aşamada tamamlandı: "API testi" ve "web testi".
## Öğrenme hedefleri

- Service Object Modeli kullanan API testing framework (RestAssured kullanmadan)
- POM modelini kullanan web testi çerçevesi
- Defect reports
- BDD ve TDD liderliğindeki web testi
- Cucumber scripts kullanıcı story'lerini izlemek ve test etmek için "StepDefs" oluşturma
- Selenium WebDriver'ı kullanma
- Keşif amaçlı bir Test Charter oluşturun

## User Stories

Ne test edildi?

API test çerçevesi, beklenen yanıt kodlarını ve mesajları kontrol etmek için farklı uç noktalarda belirli API çağrılarını test eder. Bunu yapmak için, sık sık belirli JSON verilerinin mevcut olup olmadığını kontrol edilir ve JSON'u üzerinde test edilebilecek Java nesnelerine ayrıştırılır. Bu arada, web test frameworkü kullanıcıların beklediği ve amaçlandığı gibi çalıştıklarından emin olacağı functionality/features için test case'lere sahiptir.

İşte testlerimizi türetmek için kullandığımız kullanıcı hikayelerinden küçük bir örnek.

### Örnek Kullanıcı Hikayeleri // API

```md

"AS an automation tester, I WANT to retrieve the product list,
SO THAT product data can be presented on a website later"

"AS an automation tester, I WANT to submit a search request with a parameter, 
SO THAT I am sure search results can be retrieved and can be presented on a website later

```

### Örnek Kullanıcı Hikayeleri // Web

```md

"AS a new user who wants to create an account, I WANT to be able to register with my personal information,
SO that I can access the features"

"AS a registered user, I WANT to be able to register while I checkout my cart,
SO that I can order my items"
```

## Kabul Kriterleri (Gherkin Syntax)

### Örnek Acceptance Criteria // API

```md

Scenario: Testing the product list is populated and exists.

HAPPY Path:

GIVEN, The productList endpoint exists
WHEN, I submit a GET request to the /productsList endpoint
THEN, the status code should be 200
AND I should receive a response containing the productList (which may or may not be empty)

SAD Path:

GIVEN, The productList endpoint does not exist
WHEN, I submit a GET request to the /productsList endpoint
THEN, the status code should be 404
AND I should receive a response message that the requested resource cannot be found
```

### Örnek Acceptance Criteria // Web

```md

Scenario: Input email address on the home page and submit to sign up to the Mailing List.

GIVEN, I am on the home page      
WHEN, I enter my email address      
AND, I click the arrow button      
THEN a success message 'You have been successfully subscribed!' will be visible   

```

## Test Metrics

- API Call Tests:
  - Web sitelerinin API Test listesindeki her öğenin %100 kapsamı.

- Website Functionality Tests:
  - 17 / 26 Test vakası kapsandı, 15'i geçti.
  - Site tarafından sağlanan vakaların %65'i başarıyla test edildi.

- Cucumber Features:
  - 29 senaryo içeren 17 özellik.
  - 27 / 29 senaryo geçti = %%93.

## Project Yapısı Ve Kurulum

1. Bu depoyu forklayın ve ardından forklu depoyu yerel makinenize klonlayın.
2. Projeyi tercih ettiğiniz IDE'de açın.
3. Tercih ettiğiniz tarayıcınız için doğru sürücüyü indirin.

- Örneğin; Chrome kullanıyorsanız, Chrome sürümünüzü kontrol edin ve ilgili ChromeDriver'ı https://chromedriver.chromium.org/downloads adresinden indirin.

4. Sürücü uygulamasını kopyalayıp şu klasöre yapıştırın: `Web-And-API-Testing-Project/src/test/resources/`
5. Aynı "/resources" klasöründeki "WebTesting.properties" dosyasını açın.
6. "WebTesting.properties"te, kullandığınız sürücünün "yorumlanmamış" **yalnızca** sürücü olduğundan emin olun. Chrome kullanıyorsanız, Chrome varsayılan sürücü olduğundan bu adımı atlayın.

- Örneğin; Firefox kullanıyorsanız, "webdriver=chrome" ve "webdriver=firefox" yorumlarını kaldırın.

7. "src/test/java/com/sparta/badgerBytes/webTesting/pom/util" klasöründen "DriverFactory.getDriver()" öğesini çağırın ve "src/test/" içindeki "HomePage" sınıfının kurucusuna iletin. java/com/sparta/badgerBytes/webTesting/pom/pages`
8. Projenizi IDE'de yeniden oluşturun.

İki ana dizin vardır: apiTesting ve webTesting. API dizini, sitenin API'si için test senaryoları içerirken Web Uygulama dizini, web sitesinin kullanıcı arayüzünü test etmek için test senaryoları içerir. Her dizin kendi kullanıcı hikayelerini ve test durumlarını içerir.

## Sürecimiz

Bu proje her faz için 2 gün olmak üzere toplam 4 günde tamamlanmıştır. Toplamda 8 'sprint' vardı. Siteden kullanıcı hikayeleri geliştirerek API ile başladık ve ardından ürün biriktirme listesi öğelerimizi çizmek için bir Jira panosu kullandık. Ardından özellikleri sürekli olarak geliştirmek için TDD (Junit / Maven) ve çift programlamayı kullandık. Test senaryolarımızı sitede bize verilen listeden türetmemiz dışında, aynı metodolojiyi 2. aşamada da izledik. Selenium WebDriver ile daha iyi entegre olmak için BDD'yi 2. aşamada Cucumber ile daha açık bir şekilde takip ettik.

Sprintler sırasında, ilerlemeyi tartışmak için sabahları/öğleden sonraları bir araya geldik ve ardından programlama çiftlerini birikmiş liste biletlerine topluca atardık. Engelleyiciler hakkında konuşmak, Kanban panosunu güncellemek ve ertesi gün için görev dağılımı yapmak üzere oturumlarımızı retro'larla sonlandırdık.

Proje, SOLID ve OOP ilkelerini uygular ve uygun olduğunda iyi bilinen tasarım modellerini kullanır. Çalışma zamanı günlüğü için log4j2'yi kullandık ve uygun olduğunda exception handling yapıldı.

