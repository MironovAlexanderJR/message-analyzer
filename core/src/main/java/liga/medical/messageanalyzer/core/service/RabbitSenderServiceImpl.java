package liga.medical.messageanalyzer.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.commondto.Type;
import liga.medical.messageanalyzer.core.annoatations.dbLog;
import liga.medical.messageanalyzer.core.api.RabbitSenderService;
import liga.medical.messageanalyzer.dto.RabbitMessageFirstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitSenderServiceImpl implements RabbitSenderService {

    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper;

    @Override
    @dbLog
    public void sendMessage(RabbitMessageFirstDto messageDto, String queue) throws JsonProcessingException {
        String type = messageDto.getType();
        if (!type.equals(Type.ALERT.toString()) && !type.equals(Type.DAILY.toString())) {
            messageDto.setType("ERROR");
        }

        String messageStr = objectMapper.writeValueAsString(messageDto);
        amqpTemplate.convertAndSend(queue, messageStr);
        log.info("Сообщение {} в очередь {} отправленно.", messageStr, queue);
    }
}
