package kots.transfersgateway.controller;

import kots.commons.Transfer;
import kots.transfersgateway.controller.request.TransferRequest;
import kots.transfersgateway.service.TransferProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/transfers")
@RequiredArgsConstructor
class TransferController {

    private final TransferProducer transferProducer;

    @PostMapping
    void saveTransfer(@RequestBody TransferRequest request) {
        log.info("Received transfer request: {}", request);
        Transfer transfer = new Transfer();
        transfer.setAmount(request.getAmount());
        transfer.setRecipientAccount(request.getRecipientAccount());
        transfer.setSenderAccount(request.getSenderAccount());
        transfer.setTitle(request.getTitle());

        transferProducer.sendTransfer(transfer);
    }
}
