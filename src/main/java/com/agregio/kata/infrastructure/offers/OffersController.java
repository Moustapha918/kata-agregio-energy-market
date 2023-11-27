package com.agregio.kata.infrastructure.offers;

import com.agregio.kata.domain.usecases.PwoFunctionalException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.agregio.kata.infrastructure.WebConstants.API_ROOT_URL;


@RestController
public class OffersController {

    private final OfferApplication offerApplication;

    public OffersController(OfferApplication offerApplication) {
        this.offerApplication = offerApplication;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = API_ROOT_URL + "/offers")
    public ResponseEntity<OfferDTO> createOffer(@RequestBody OfferCreationDTO offerToCreate) throws PwoFunctionalException {
        var  createdOffer = offerApplication.createOffer(offerToCreate);
        return ResponseEntity.ok(createdOffer);
    }
}
