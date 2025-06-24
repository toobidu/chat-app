# API Gateway Service 🚀

## Giới thiệu 🌟

**API Gateway Service** là điểm vào chính trong kiến trúc microservices, đóng vai trò **cổng trung gian** giữa các
client (ứng dụng web, mobile, third-party) và các dịch vụ backend. Module này giúp đơn giản hóa giao tiếp, tăng cường
bảo mật và quản lý hiệu quả các yêu cầu trong hệ thống phân tán. Được xây dựng dựa trên Spring Cloud Gateway, nó đảm bảo
**hiệu suất cao**, **khả năng mở rộng** và **tính linh hoạt**.

## Mục đích 🛠️

API Gateway cung cấp các chức năng chính:

- **Định tuyến yêu cầu** 🌐: Chuyển tiếp các yêu cầu từ client đến các microservices phù hợp dựa trên các quy tắc cấu
  hình.
- **Bảo mật** 🔒: Xác thực và phân quyền người dùng, bảo vệ các endpoint bằng các cơ chế như OAuth2, JWT.
- **Cân bằng tải** ⚖️: Phân phối lưu lượng đến các instance của dịch vụ, tích hợp với Eureka Server để khám phá dịch vụ
  động.
- **Quản lý API** 📋: Áp dụng các chính sách như giới hạn lưu lượng (rate limiting), lưu trữ cache và giám sát yêu cầu.

## Tính năng chính ✨

- **Định tuyến động**: Hỗ trợ cấu hình định tuyến dựa trên đường dẫn, header hoặc tham số. 🚦
- **Lọc yêu cầu**: Cho phép thêm, sửa hoặc xóa header, kiểm tra yêu cầu trước khi chuyển tiếp. 🛡️
- **Tích hợp Eureka**: Khám phá dịch vụ tự động thông qua Eureka Server. ☁️
- **Khả năng mở rộng**: Hỗ trợ triển khai cụm để đảm bảo tính sẵn sàng cao. 📈

## Thiết lập và Cấu hình ⚙️

1. **Thêm phụ thuộc**:
    - Thêm `spring-cloud-starter-gateway-server-webmvc` và `spring-cloud-starter-netflix-eureka-client` vào file `pom.xml`.
   ```xml
   <dependencies>
       <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway-server-webmvc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
   </dependencies>
   ```

2. **Kích hoạt API Gateway**:
    - Sử dụng annotation `@EnableDiscoveryClient` trong lớp ứng dụng chính.
   ```java
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

   @SpringBootApplication
   @EnableDiscoveryClient
   public class ApiGatewayServiceApplication {
       public static void main(String[] args) {
           SpringApplication.run(ApiGatewayApplication.class, args);
       }
   }
   ```

3. **Cấu hình**:
    - Cấu hình API Gateway trong file `application.yml`.
   ```yaml
   server:
     port: 8080
   spring:
     application:
       name: api-gateway
     cloud:
       gateway:
         routes:
         - id: user-service
           uri: lb://USER-SERVICE
           predicates:
           - Path=/users/**
         - id: order-service
           uri: lb://ORDER-SERVICE
           predicates:
           - Path=/orders/**
   eureka:
     client:
       service-url:
         defaultZone: http://localhost:8761/eureka/
   ```

4. **Chạy Gateway**:
    - Khởi động ứng dụng, API Gateway sẽ hoạt động tại `http://localhost:8080`.

## Sử dụng trong Microservices 🧩

- **Định tuyến**: Client gửi yêu cầu đến API Gateway, nó sẽ chuyển tiếp đến dịch vụ tương ứng dựa trên cấu hình route.
- **Khám phá dịch vụ**: Tích hợp với Eureka Server để tự động khám phá các instance dịch vụ.
- **Bảo mật**: Sử dụng bộ lọc (filter) để thêm xác thực, kiểm tra token hoặc giới hạn lưu lượng.

## Thực tiễn tốt ✅

- **Bảo mật**: Tích hợp Spring Security với OAuth2 hoặc JWT để bảo vệ endpoint. 🔒
- **Giám sát**: Sử dụng Prometheus và Grafana để theo dõi lưu lượng và hiệu suất. 📈
- **Tối ưu hiệu suất**: Áp dụng cache cho các yêu cầu tĩnh và giới hạn lưu lượng để tránh quá tải.
- **Triển khai cụm**: Chạy nhiều instance API Gateway để đảm bảo tính sẵn sàng cao.

## Xử lý sự cố 🛠️

- **Yêu cầu không được định tuyến?** Kiểm tra cấu hình route và đảm bảo dịch vụ đã đăng ký với Eureka.
- **Lỗi kết nối Eureka?** Xác minh URL Eureka trong `application.yml`.
- **Hiệu suất thấp?** Kiểm tra giới hạn lưu lượng và tối ưu bộ lọc.

🌈 **API Gateway Service** là cánh cổng kết nối client và microservices, đảm bảo giao tiếp an toàn và hiệu quả! 🌈