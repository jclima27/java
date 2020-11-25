# Aplicação para utilizar logback para geração de logs


## Exemplos de arquivo logback.xml(arquivo deve ser adicionado dentro de src/main/resources)

##### 1. Exemplo de logback para exibição de log no console
``` 
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
		<encoder>
			<pattern>
				%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger{36}.%M - %msg%n
			</pattern>
		</encoder>
	</appender>
	
	<root level="info">
		<appender-ref ref="STDOUT"/>
	</root>
</configuration>    
``` 
##### 2. Exemplo de logback para saida do log em um arquivo
``` 
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>logs/spring-boot-logging.log</file>
        <append>true</append>
        <encoder>
            <pattern>
                %d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger{36}.%M - %msg%n
            </pattern>
        </encoder>
    </appender>
    <root level="info">
        <appender-ref ref="FILE"/>
    </root>
 </configuration>
``` 
##### 3. Exemplo de logback para saida do log em arquivos limitados por tamanho e dividos por dia do Mês
``` 
<property name="LOG_PATH" value="logs2"/>
  <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
  	<file>${LOG_PATH}/spring-boot-logging.log</file>
  	<encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
    	<Pattern>
           %d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
        </Pattern>
    </encoder>
    <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
    	<fileNamePattern>
    		${LOG_PATH}/spring-boot-logging.%d{yyyy-MM-dd}.log
    	</fileNamePattern>
    	<maxHistory>10</maxHistory>
    	 Qtde maxima do tamanho do arquivo 
    	<totalSizeCap>100MB</totalSizeCap>
    </rollingPolicy>
  </appender>
  <root level="info">
	<appender-ref ref="FILE"/>
 </root>
</configuration>
```
  
#### 3. Detalhes do logback
##### Tipos de appender

appender para saida do log no console
``` 
<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
```

appender para saida do log em arquivo
``` 
<appender name="SAVE-TO-FILE" class="ch.qos.logback.core.FileAppender">
```

appender para saida do log em arquivos
``` 
<appender name="SAVE-TO-FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
```

##### Adicionando variavel pra ser usado o valor em mais de um local no logback.xml
```
<property name="LOG_PATH" value="logs2"/>
```

##### Caminho e nome do arquivo onde será salvo os logs da aplicação
```
<file>${LOG_PATH}/spring-boot-logging.log</file>
```

##### Formatação do log
- %d mostra a hora em que a mensagem de log ocorreu em formatos que SimpleDateFormatpermitem.
- %thread exibe o nome do thread em que a mensagem de log ocorreu.
- $-5level - produz o nível de registro da mensagem de registro.
- %logger{36}- exibe o pacote + nome da classe em que a mensagem de log ocorreu. O número entre colchetes representa o comprimento máximo do pacote + nome da classe. 
- %M exibe o nome do método em que a mensagem de log ocorreu (aparentemente, é muito lento de usar e não é recomendado
- %msg emite a mensagem de registro real.
- %n quebra de linha.
- %magenta() - define a cor da saída contida nos colchetes para magenta (outras cores estão disponíveis).
- highlight() - define a cor da saída contida nos colchetes, dependendo do nível de registro (por exemplo ERROR = vermelho).
```
<encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
    <Pattern>
        %d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
    </Pattern>
</encoder>
```
##### Hierarquia de Logs

Os logs tem a seguinte hierarquia
- trace
- debug
- info
- warn
- error

- level e referente a hierarquia de logs
- appender-ref se refere a qual appender esta se referindo
- resumindo vai ser aplicado a hierarquia de log a partir do tipo info para o appender com o nome de STDOUT

```
<root level="info">
    <appender-ref ref="STDOUT"/>
</root>
```

Então se for seguir o exemplo acima e tentar imprimir esses logs, só irá ser impresso do Log do tipo "Info" pra baixo, ou seja ele sempre imprime o level informado e os que estão abaixo dele
```
    LOGGER.trace("doStuff needed more information - {}", value);
    LOGGER.debug("doStuff needed to debug - {}", value);
    LOGGER.info("doStuff took input - {}", value);
    LOGGER.warn("doStuff needed to warn - {}", value);
    LOGGER.error("doStuff encountered an error with value - {}", value);
```

##### Politica de impressão dos logs

- fileNamePattern os arquivos vão ser gerados diariamente
- MaxHistory - eles vão permanecer por no maximo 10 dias
- totalSizeCap - Tamanho máximo de cada arquivo de log
```
<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
    <fileNamePattern>
        ${LOG_PATH}/archived/log_%d{dd-MM-yyyy}.log
    </fileNamePattern>
    <maxHistory>10</maxHistory>
    <totalSizeCap>100MB</totalSizeCap>
</rollingPolicy>
```
##### Definindo um log especifico para uma classe

Nesse caso esta sendo adicionado um log especifico para a classe MyServiceImpl(poderia ser o pacote da classe ai ficaria name="com.lankydan") com o level do tipo debug
se referindo a um appender com o nome STDOUT 
```
<logger name="com.lankydan.service.MyServiceImpl" level="debug">
  <appender-ref ref="STDOUT" />
</logger>
```

por padrão o logger herda o <root level="info"></root> para não ter a herança é só adicionar additivity="false"

```
<logger name="com.lankydan.service.MyServiceImpl" additivity="false" level="debug">
  <appender-ref ref="STDOUT" />
</logger>
```


## Testando a aplicação

Necessário apenas adicionar um dos exemplos de logback e startar a aplicação  



  
