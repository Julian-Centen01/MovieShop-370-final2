<html>
<head>
<style>
    body {
        text-align: center;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 95%;}
    .total {
        font-size: 76px;
        font-weight: bold;}
</style>
</head>
<body>
<div>
    <form class="button" action="/pay" method="post">
        <input type="submit" value="Checkout" />
    </form>
</div>
</body>
</html>
Collapse
checkout.html
1 KB
const express = require('express');
const paypal = require('paypal-rest-sdk');
const PORT = 3000;

const price = "6.25";

// configure to use my paypal sandbox account
paypal.configure({
    'mode': 'sandbox',
    'client_id': 'ARMfdSpP7h0lrwZcKny8flX5qfzMBgJfiv6m7BipaEV8sXGag58lJ36kEU6zbIbfOBP78GeOABl9O1pF',
    'client_secret': 'EIZsi0a87y9Xymsn3aP0_XVMxl7OIYSCnAvdeW-bvHXOzhpYZmsEYreW5VsWhZMfLZfAyIhGHpcIeGYy'
});

const checkout = express();

checkout.get('/', (req, res) => res.sendFile(__dirname + "/Cart.js"));
checkout.listen(PORT, () => console.log(`Server Started on ${PORT}`));

// method for payment
checkout.post('/pay', (req, res) => {
    const create_payment_json = {
        "intent": "sale",
        "payer": {
            "payment_method": "paypal"
        },
        "redirect_urls": {
            "return_url": "http://localhost:3000/success",
            "cancel_url": "http://localhost:3000/cancel"
        },
        "transactions": [{
            "amount": {
                "currency": "USD",
                "total": price
            }
        }]
    };

    checkout.get('/success', (req, res) => {
        const customerID = req.query.PayerID;
        const paymentId = req.query.paymentId;

        const execute_payment_json = {
            "payer_id": customerID,
            "transactions": [{
                "amount": {
                    "currency": "USD",
                    "total": price
                }
            }]
        };

        // execute payment and check for errors
        paypal.payment.execute(paymentId, execute_payment_json, function (error, payment) {
            if (error) {
                console.log(error.response);
                throw error;
            } else {
                console.log(JSON.stringify(payment));
                res.send('Success');
            }
        });

    });

    paypal.payment.create(create_payment_json, function (error, payment) {
        if (error) {
            throw error;
        } else {
            for (let i = 0;i < payment.links.length;i++) {
                if (payment.links[i].rel === 'approval_url') {
                    res.redirect(payment.links[i].href);
                }
            }
        }
    });
});

// cancel payment
checkout.get('/cancel', (req, res) => res.send('Cancelled'));