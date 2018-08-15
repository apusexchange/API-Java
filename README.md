# API-Java

SDK of the payment platform Apus.
* Language: Java

## Features

* [x] Payments by card.
* [ ] Recurring payments.
* [ ] Payments by transfer.
* [ ] Payment inquiry.

<hr>

## Blockchains

| Blockchain       | Constante             | Recorrente |
|------------------|-----------------------|------------|
| Bitcoin          | Blockchain.BTC        | Sim        |
| Decred           | CreditCard.DCR        | Sim        |
| Ethereum         | CreditCard.ETH        | Sim        |
| Litecoin         | CreditCard.LTC        | Sim        |

<hr>

## Payments by card.

Payments using card number and password.

### Request

> POST https://api.apus.exchange/v1/pay/

```java
{
  "card": "0000111122223333",
  "password": "*******",
  "type": Blockchain.BTC,
  "amount": 10.00,
  "currency": "BRL"
}
```
 
### Response

```java
{
    "status": true,
    "message": "Payment accept",
    "txid": "d5a82f2e8469b1d30a98cbca29c40cb732c46c6b19ab729e1785806237417153",
    "data": {
        "serial": "A666A",
        "buyer": "Buyer Complete Name"
    }
}
```
