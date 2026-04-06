// ==========================================
// 1. Ap dung ISP (Phan tach giao dien)
// Thay vi tao 1 interface khong lo chua ca 2 ham, 
// ta chia nho thanh cac interface chuyen biet.
// ==========================================
interface AudioPlayable {
    void playAudio(String file);
}

interface VideoPlayable {
    void playVideo(String file);
}

// ==========================================
// 2. Cac lop trien khai cu the
// ==========================================
class AudioPlayer implements AudioPlayable {
    @Override
    public void playAudio(String file) {
        System.out.println("[Audio] Dang phat am thanh: " + file);
    }
}

class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo(String file) {
        System.out.println("[Video] Dang phat hinh anh: " + file);
    }
}

// ==========================================
// 3. Ap dung DIP (Dao nguoc phu thuoc)
// Lop cap cao (MediaPlayer) khong phu thuoc vao lop cap thap (AudioPlayer/VideoPlayer)
// No chi phu thuoc vao cac Interface truu tuong.
// ==========================================
class MediaPlayer {
    private AudioPlayable audioDevice;
    private VideoPlayable videoDevice;

    // Phu thuoc duoc "tiem" (inject) tu ben ngoai vao thong qua constructor
    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audioDevice = audio;
        this.videoDevice = video;
    }

    // Cac ham uy quyen xu ly
    public void playAudio(String file) {
        if (audioDevice != null) {
            audioDevice.playAudio(file);
        } else {
            System.out.println("Loi: Chua ket noi thiet bi phat am thanh!");
        }
    }

    public void playVideo(String file) {
        if (videoDevice != null) {
            videoDevice.playVideo(file);
        } else {
            System.out.println("Loi: Chua ket noi thiet bi phat hinh anh!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== He thong MediaPlayer ===");

        AudioPlayable myAudio = new AudioPlayer();
        VideoPlayable myVideo = new VideoPlayer();

        MediaPlayer player = new MediaPlayer(myAudio, myVideo);

        player.playAudio("nhac_nen_geometry_dash.mp3");
        player.playVideo("bai_giang_oop.mp4");
    }
}