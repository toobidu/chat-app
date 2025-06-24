# Eureka Server 🚀

## Tổng quan 🌟
**Eureka Server** là thành phần cốt lõi trong kiến trúc microservices, đóng vai trò **trình đăng ký dịch vụ** và **máy chủ khám phá dịch vụ**. Module này cho phép các microservices tự động khám phá và giao tiếp với nhau mà không cần mã hóa cứng địa chỉ. Dựa trên Eureka của Netflix, nó đảm bảo **tính sẵn sàng cao**, **khả năng mở rộng** và **chịu lỗi** trong hệ thống phân tán.

## Mục đích 🛠️
Eureka Server cung cấp các chức năng chính:
- **Đăng ký dịch vụ** 📋: Microservices đăng ký siêu dữ liệu (host, cổng, trạng thái sức khỏe) với Eureka Server khi khởi động.
- **Khám phá dịch vụ** 🔍: Microservices client truy vấn Eureka Server để tìm vị trí các dịch vụ khác, hỗ trợ giao tiếp động.
- **Cân bằng tải** ⚖️: Tích hợp với bộ cân bằng tải phía client (Spring Cloud LoadBalancer) để phân phối lưu lượng giữa các instance.
- **Giám sát sức khỏe** ❤️: Theo dõi trạng thái sức khỏe của các dịch vụ, loại bỏ instance không lành mạnh khỏi danh sách.

## Tính năng chính ✨
- **Tính sẵn sàng cao**: Hỗ trợ cụm hóa để chịu lỗi và mở rộng. 🌐
- **Chế độ tự bảo vệ**: Ngăn xóa dịch vụ khi mất kết nối mạng. 🛡️
- **API REST**: Cung cấp endpoint để truy vấn thông tin instance và trạng thái. 📡
- **Tích hợp Spring Boot**: Dễ dàng cấu hình với Spring Cloud Netflix. ☁️

## Thiết lập và Cấu hình ⚙️
1. **Thêm phụ thuộc**:
    - Thêm `spring-cloud-starter-netflix-eureka-server` vào file `pom.xml`.
   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
   </dependency>
   ```

2. **Kích hoạt Eureka Server**:
    - Sử dụng annotation `@EnableEurekaServer` trong lớp ứng dụng chính.
   ```java
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

   @SpringBootApplication
   @EnableEurekaServer
   public class EurekaServerApplication {
       public static void main(String[] args) {
           SpringApplication.run(EurekaServerApplication.class, args);
       }
   }
   ```

3. **Cấu hình**:
    - Cấu hình Eureka Server trong `application.yml`.
   ```yaml
   server:
     port: 8761
   eureka:
     client:
       register-with-eureka: false
       fetch-registry: false
     server:
       enable-self-preservation: true
   ```

4. **Chạy Server**:
    - Khởi động ứng dụng, Eureka Server sẽ hoạt động tại `http://localhost:8761`.

## Sử dụng trong Microservices 🧩
- **Đăng ký Client**: Microservices sử dụng `spring-cloud-starter-netflix-eureka-client` để đăng ký với Eureka Server.
- **Khám phá dịch vụ**: Client dùng Eureka Client hoặc Spring Cloud LoadBalancer để tìm và giao tiếp với dịch vụ khác.
- **Bảng điều khiển**: Truy cập `http://localhost:8761` để xem danh sách dịch vụ và trạng thái. 📊

## Thực tiễn tốt ✅
- **Tính sẵn sàng cao**: Triển khai nhiều instance Eureka Server trong cụm để dự phòng.
- **Bảo mật**: Sử dụng Spring Security hoặc API Gateway để bảo vệ Eureka Server. 🔒
- **Giám sát**: Tích hợp với Prometheus, Grafana để theo dõi sức khỏe và hiệu suất. 📈
- **Tùy chỉnh cấu hình**: Điều chỉnh chế độ tự bảo vệ và thời gian xóa instance theo nhu cầu.

## Xử lý sự cố 🛠️
- **Dịch vụ không đăng ký?** Kiểm tra URL server trong cấu hình client.
- **Chế độ tự bảo vệ?** Xác minh mạng và điều chỉnh `eureka.server.enable-self-preservation`.
- **Bảng điều khiển không tải?** Đảm bảo server chạy trên cổng 8761.

🌈 **Eureka Server** là trái tim của hệ sinh thái microservices, đảm bảo khám phá và giao tiếp dịch vụ mượt mà! 🌈