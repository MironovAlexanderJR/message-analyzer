package liga.medical.messageanalyzer.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.commondto.DebugLogDto;
import liga.medical.messageanalyzer.core.api.RabbitSenderService;
import liga.medical.messageanalyzer.core.clients.CommonClient;
import liga.medical.messageanalyzer.core.config.RabbitConfig;
import liga.medical.messageanalyzer.dto.RabbitMessageFirstDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
@RequiredArgsConstructor
public class RabbitController {

    private final RabbitSenderService rabbitSenderService;
    private final CommonClient commonClient;

    @PostMapping("/send")
    public void sendMessage(@RequestBody RabbitMessageFirstDto messageDto) throws JsonProcessingException {
        rabbitSenderService.sendMessage(messageDto, RabbitConfig.COMMON_MONITORING_QUEUE_NAME);
    }
}
