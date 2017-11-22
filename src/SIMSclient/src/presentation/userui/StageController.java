package SIMSclient.src.presentation.userui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class StageController {

    private HashMap<String, Stage> stages = new HashMap<String, Stage>();


    public void addStage(String name, Stage stage) {
        stages.put(name, stage);
    }

    public Stage getStage(String name) {
        return stages.get(name);
    }


    public void setPrimaryStage(String primaryStageName, Stage primaryStage) {
        this.addStage(primaryStageName, primaryStage);
    }


    public boolean loadStage(String name, String resources) {
        try {
            //����FXML��Դ�ļ�
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resources));
            Pane tempPane = (Pane) loader.load();

            //ͨ��Loader��ȡFXML��Ӧ��ViewCtr��������StageControllerע�뵽ViewCtr��
            ControlledStage controlledStage = (ControlledStage) loader.getController();
            controlledStage.setStageController(this);

            //�����Ӧ��Stage
            Scene tempScene = new Scene(tempPane);
            Stage tempStage = new Stage();
            tempStage.setScene(tempScene);


            //�����úõ�Stage�ŵ�HashMap��
            this.addStage(name, tempStage);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ��ʾStage���������κ�Stage
     *
     * @param name ��Ҫ��ʾ�Ĵ��ڵ�����
     * @return �Ƿ���ʾ�ɹ�
     */
    public boolean setStage(String name) {
        this.getStage(name).show();
        return true;
    }


    /**
     * ��ʾStage�����ض�Ӧ�Ĵ���
     *
     * @param show  ��Ҫ��ʾ�Ĵ���
     * @param close ��Ҫɾ���Ĵ���
     * @return
     */
    public boolean setStage(String show, String close) {
        getStage(close).close();
        setStage(show);
        return true;
    }


    /**
     * ��Map��ɾ��Stage���ض���
     *
     * @param name ��Ҫɾ����fxml�����ļ���
     * @return �Ƿ�ɾ���ɹ�
     */
    public boolean unloadStage(String name) {
        if (stages.remove(name) == null) {
            System.out.println("���ڲ����ڣ���������");
            return false;
        } else {
            System.out.println("�����Ƴ��ɹ�");
            return true;
        }
    }
}
