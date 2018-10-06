# APUS-Java 

ApusPayments is a plataform to make payments using criptocurrencies.

* Language: Java

[Documentation API](https://docs.apuspayments.com/)

[![](https://jitpack.io/v/apuspayments/API-Java.svg)](https://jitpack.io/#apuspayments/API-Java)

## Examples of use

* [x] Payments by card.
* [x] Recurring payments.
* [x] Cancel payment.
* [x] Consult payments.
* [x] Cryptocurrency recharge.

<hr>

## Configuration 

### For gradle

Add it in your root build.gradle at the end of repositories:

```java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```java
dependencies {
	implementation 'com.github.apuspayments:API-Java:1.0.2'
}
```

### For maven

```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

Add the dependency

```xml
<dependency>
	<groupId>com.github.apuspayments</groupId>
	<artifactId>API-Java</artifactId>
	<version>Tag</version>
</dependency>
```
### Call SDK

* Call ApusPaymentAPI and choose environment:
     * SANDBOX
     * PRODUCTION

```java
ApusPaymentAPI apusPaymentAPI = new ApusPaymentAPI(Environment.SANDBOX)
```
* Set callback to handle the API function

```java
apusPaymentAPI.setCallback(new RestService.ApusCallback() {
	@Override
	public void onResponse(ApusResponse apusResponse) {
	}
});
```

## Make a payments

```java
ApusPaymentAPI apusPaymentAPI = new ApusPaymentAPI(Environment.SANDBOX)

apusPaymentAPI.start(new MakePayment.Builder()
.withAmount(10)
.withBlockChain(BlockChain.Type.LTC)
.withCurrency(Currency.Type.BRL)
.withPan("9999999999999999")
.withPassWord("1234")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.build());
```
<hr>

## Make a recurring payments

```java
ApusPaymentAPI apusPaymentAPI = new ApusPaymentAPI(Environment.SANDBOX)

apusPaymentAPI.start(new RecurringPayment.Builder()
.withAmount(10)
.withBlockChain(BlockChain.Type.LTC)
.withCurrency(Currency.Type.BRL)
.withPeriod(Period.M)
.withPan("9999999999999999")
.withPassWord("1234")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.build());
```
<hr>

## Search payments

```java
ApusPaymentAPI apusPaymentAPI = new ApusPaymentAPI(Environment.SANDBOX)

apusPaymentAPI.start(new SearchPayment.Builder()
.withBlockchain(BlockChain.Type.LTC)
.withCurrency(Currency.Type.BRL)
.withTxId("2bf779e2a311c2629df977b0bb105879411fd71f5839972c4ed1d3278f80170f")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.build());
```
<hr>

## Cancel a payment

```java
ApusPaymentAPI apusPaymentAPI = new ApusPaymentAPI(Environment.SANDBOX)

 apusPaymentAPI.start(new CancelPayment.Builder()
.withPassWord("1234")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.withTxId("2bf779e2a311c2629df977b0bb105879411fd71f5839972c4ed1d3278f80170f")
.build());
```
<hr>

## Recharge of Crypto Balance

```java
ApusPaymentAPI apusPaymentAPI = new ApusPaymentAPI(Environment.SANDBOX)

apusPaymentAPI.start(new RechargeCryptoBalance.Builder()
.withAmount(10)
.withBlockChain(BlockChain.Type.LTC)
.withCurrency(Currency.Type.BRL)
.withPan("9999999999999999")
.withPassWord("1234")
.withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
.build());
```
