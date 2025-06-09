import Receiving.*;
import Storage.*;
import Payment.*;
import Dispatch.*;
import LogisticProses.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PenerimaanBarang pb = null;
        CustomerData customer = null;
        Storage storage = new Storage("ST001", "Main Warehouse", 1000);

        while (true) {
            System.out.println("\n=== MENU UTAMA SISTEM LOGISTIK ===");
            System.out.println("1. Receiving");
            System.out.println("2. Storage");
            System.out.println("3. Payment");
            System.out.println("4. Dispatch");
            System.out.println("5. Logistic Process");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu utama: ");
            int menuUtama = scanner.nextInt();
            scanner.nextLine();

            switch (menuUtama) {
                case 1: // Receiving
                    System.out.println("\n-- Menu Receiving --");
                    System.out.println("1. Scan Penerimaan Barang");
                    System.out.println("2. Tampilkan Barang Diterima");
                    System.out.println("3. Input Data Customer");
                    System.out.println("4. Tampilkan Info Kontak Customer");
                    System.out.print("Pilih opsi: ");
                    int recOpt = scanner.nextInt();
                    scanner.nextLine();

                    switch (recOpt) {
                        case 1:
                            System.out.print("Receiving ID: ");
                            String receivingId = scanner.nextLine();
                            System.out.print("Tanggal Diterima (YYYY-MM-DD): ");
                            String dateStr = scanner.nextLine();
                            LocalDate dateReceived = LocalDate.parse(dateStr);
                            System.out.print("Supplier Name: ");
                            String supplierName = scanner.nextLine();

                            Receiving receiving = new Receiving(receivingId, dateReceived, supplierName);
                            receiving.recordReceiving();
                            receiving.printReceivingDetails();

                            pb = new PenerimaanBarang(receivingId, dateReceived, supplierName);
                            String item;
                            do {
                                System.out.print("Input Item (atau ketik 'done'): ");
                                item = scanner.nextLine();
                                if (!item.equalsIgnoreCase("done")) {
                                    pb.addItem(item);
                                }
                            } while (!item.equalsIgnoreCase("done"));
                            break;
                        case 2:
                            if (pb != null) {
                                System.out.println("Items: " + pb.getItemList());
                            } else {
                                System.out.println("Belum ada data.");
                            }
                            break;
                        case 3:
                            System.out.print("Customer ID: ");
                            String custId = scanner.nextLine();
                            System.out.print("Nama: ");
                            String name = scanner.nextLine();
                            System.out.print("Alamat: ");
                            String address = scanner.nextLine();
                            System.out.print("Nomor Telepon: ");
                            String phone = scanner.nextLine();
                            customer = new CustomerData(custId, name, address, phone);
                            break;
                        case 4:
                            if (customer != null) {
                                System.out.println(customer.getContactInfo());
                            } else {
                                System.out.println("Data customer belum dimasukkan.");
                            }
                            break;
                    }
                    break;

                case 2: // Storage
                    System.out.println("\n-- Menu Storage --");
                    System.out.println("1. Simpan Barang dari Receiving");
                    System.out.println("2. Tampilkan Laporan Gudang");
                    System.out.println("3. Record Barang Masuk");
                    System.out.println("4. Record Barang Keluar");
                    System.out.print("Pilih opsi: ");
                    int stoOpt = scanner.nextInt();
                    scanner.nextLine();

                    switch (stoOpt) {
                        case 1:
                            if (pb != null) {
                                for (String storedItem : pb.getItemList()) {
                                    storage.storeItem(storedItem, 1);
                                }
                                System.out.println("Barang dari Receiving disimpan ke Gudang.");
                            } else {
                                System.out.println("Data Penerimaan Barang belum tersedia.");
                            }
                            break;
                        case 2:
                            storage.printStorageReport();
                            break;
                        case 3:
                            System.out.print("Item Code: ");
                            String codeIn = scanner.nextLine();
                            System.out.print("Qty In: ");
                            int qtyIn = scanner.nextInt();
                            scanner.nextLine();
                            DataBarangMasuk dbm = new DataBarangMasuk(codeIn, qtyIn, LocalDate.now());
                            dbm.recordIn();
                            System.out.println(dbm.getInDetails());
                            break;
                        case 4:
                            System.out.print("Item Code: ");
                            String codeOut = scanner.nextLine();
                            System.out.print("Qty Out: ");
                            int qtyOut = scanner.nextInt();
                            scanner.nextLine();
                            DataBarangKeluar dbk = new DataBarangKeluar(codeOut, qtyOut, LocalDate.now());
                            dbk.recordOut();
                            System.out.println(dbk.getOutDetails());
                            break;
                    }
                    break;

                case 3: // Payment
                    System.out.println("\n-- Menu Payment --");
                    System.out.println("1. Proses Pembayaran");
                    System.out.println("2. COD - Tandai Lunas");
                    System.out.print("Pilih opsi: ");
                    int payOpt = scanner.nextInt();
                    scanner.nextLine();

                    if (payOpt == 1) {
                        Payment payment = new Payment();
                        payment.processPayment();
                        System.out.println(payment.getPaymentStatus());
                    } else if (payOpt == 2) {
                        COD cod = new COD();
                        cod.markAsPaid();
                        System.out.println(cod.getDeliveryDetails());
                    }
                    break;

                case 4: // Dispatch
                    System.out.println("\n-- Menu Dispatch --");
                    System.out.println("1. Jadwal Keberangkatan");
                    System.out.println("2. Rencana Rute");
                    System.out.print("Pilih opsi: ");
                    int disOpt = scanner.nextInt();
                    scanner.nextLine();

                    if (disOpt == 1) {
                        JadwalKeberangkatan jadwal = new JadwalKeberangkatan("SCH001", LocalTime.of(8, 30));
                        jadwal.updateTime(LocalTime.of(9, 0));
                        System.out.println(jadwal.getSchedule());
                    } else if (disOpt == 2) {
                        RoutePlanning route = new RoutePlanning("RT001");
                        route.planRoute();
                        System.out.println(route.getRouteDetails());
                    }
                    break;

                case 5: // Logistic Process
                    System.out.println("\n-- Menu Logistic Process --");
                    System.out.println("1. Konfirmasi Penerima");
                    System.out.println("2. Proses Retur");
                    System.out.println("3. Update Status Pengiriman");
                    System.out.print("Pilih opsi: ");
                    int logOpt = scanner.nextInt();
                    scanner.nextLine();

                    switch (logOpt) {
                        case 1:
                            ReceiverBarang receiver = new ReceiverBarang("RC001", "Andi");
                            receiver.confirmReception();
                            System.out.println(receiver.getReceiverInfo());
                            break;
                        case 2:
                            ReturnBarang ret = new ReturnBarang("RT001", "Rusak", LocalDate.now());
                            ret.processReturn();
                            System.out.println(ret.getReturnInfo());
                            break;
                        case 3:
                            ShipmentStatus ss = new ShipmentStatus("SH001", "Dalam Proses", LocalDateTime.now());
                            ss.updateStatus("Terkirim");
                            System.out.println(ss.getStatus());
                            break;
                    }
                    break;

                case 6:
                    System.out.println("Keluar...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
