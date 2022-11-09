package liga.medical.messageanalyzer.core.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.messageanalyzer.dto.RabbitMessageFirstDto;

public interface RabbitSenderService {

    void sendMessage(RabbitMessageFirstDto messageDto, String queue) throws JsonProcessingException;
}
