
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.annotations.SerializedName;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
@RestController

public class PaymentController {
    static class CreatePayment {
        @SerializedName("items")
        Object[] items;
    
        public Object[] getItems() {
          return items;
        }
      }
    
      static class CreatePaymentResponse {
        private String clientSecret;
        public CreatePaymentResponse(String clientSecret) {
          this.clientSecret = clientSecret;
        }
      }
    
    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {
         PaymentIntentCreateParams params; PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setAmount(15 * 100L)//create payment - payment calculator to be inserted here to calculate patients bill
                .setCurrency("eur") 
                .build();
      
            // Create a PaymentIntent with the order amount and currency
            PaymentIntent intent = PaymentIntent.create(createParams);
      
            return new CreatePaymentResponse(intent.getClientSecret());
            
          }

    }
  