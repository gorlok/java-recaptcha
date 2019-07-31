# Google reCAPTCHA for Java

Minimal Java web example of reCAPTCHA, using Java 7, Apache Tomcat and a plain Servlet. No extra requeriments.

Updated: 2019/July

### Register service on reCAPTCHA

Go to [https://www.google.com/recaptcha/](https://www.google.com/recaptcha/) and enter into "Admin Console".

Register a new site. Enter any label. Select *"reCAPTCHA v2"* type. Enter *"localhost"* or/and your hostname at "Domains". Accept service's conditions and Save.

Save for later your "site key" and "secret key". You will need both them on your code.

### Update your code with your keys.

Change data-sitekey on login.html using your generated "site key".
Change secret string on VerifyRecaptcha.java using your generated "secret key".

*NOTE*: secure your keys in real world, for Turing's sake!

### Compile and run

Compile with Maven using:

```sh
mvn clean package
```

Right click on target/loginExample and select "Debug on Tomcat Server". Start Tomcat Server if needed (go to Tomcat Servers panel -> Start). 
Look at your deployed application on Tomcat, right click on it and select "Open in Browser". Or navigate your browser to http://localhost:8080/loginExample

The expected username is "admin" and the password is "1234". Try valid and invalid logins, with passed and failed captchas.

### Using VS Code for Java

Use VS Code for Java. Required plugins:
* Java Extension Pack
* Maven for Java
* Tomcat for Java

### Tomcat behind a proxy

On your Tomcat Server instance, right click on it and select "Customize JVM Options". Add this line:

```java
-Djava.net.useSystemProxies=true
```

Then restart Tomcat Server from VS Code.
