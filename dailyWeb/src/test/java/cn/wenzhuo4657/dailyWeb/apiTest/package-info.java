package cn.wenzhuo4657.dailyWeb.apiTest;


/**
 * 执行api测试，不依赖项目主体代码
 */


/**
 *      <dependency>
 *             <groupId>org.telegram</groupId>
 *             <artifactId>telegrambots-longpolling</artifactId>
 *             <version>9.2.0</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.telegram</groupId>
 *             <artifactId>telegrambots-client</artifactId>
 *             <version>9.2.0</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.telegram</groupId>
 *             <artifactId>telegrambots-abilities</artifactId>
 *             <version>9.2.0</version>
 *         </dependency>
 *
 *
 *         该版本api和旧版本api发生了较大变化，因而很多模型可能会产生幻觉，给出旧版本的答案
 *
 *         telegrambots-client： 定义 TelegramClient接口，用于实际的通信，默认实现为OkHttpTelegramClient，初始化需要botToken
 *         标志方法为：
 *         telegramClient.execute(各类封装的消息体，例如：SetMyCommands、SendPhoto)
 *
 *
 *         telegrambots-longpolling： 被动回复
 *         标志为: consume(Update update)  接受对方的消息，然后处理返回
 *
 *
 *         telegrambots-abilities：  高级抽象封装，暂不使用，报错 Cannot invoke "java.util.List.stream()" because "this.replies" is null
 *
 *
 *
 */