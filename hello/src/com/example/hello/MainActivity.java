package com.example.hello;

//import android.support.v7.app.ActionBarActivity;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_bmi = (Button)findViewById(R.id.button1);
        Button bt_images =  (Button)findViewById(R.id.button2);
        Button bt_multi_images =  (Button)findViewById(R.id.selectBtn);
        
        
        bt_bmi.setOnClickListener(calcBMI);
        bt_images.setOnClickListener(chooseImage);
        bt_multi_images.setOnClickListener(multichooseImage);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
    
 
    
    private OnClickListener chooseImage = new OnClickListener()
    {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Log.v("LogDemo","heyhey=============================================");
//			// �إ� "����ɮ� Action" �� Intent
//            Intent intent = new Intent();
//            // �L�o�ɮ׮榡
//            intent.setType( "image/*" );
//            
//            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//            
//            intent.setAction(Intent.ACTION_GET_CONTENT);
//            
//           
//            
//            // �إ� "�ɮ׿�ܾ�" �� Intent  (�ĤG�ӰѼ�: ��ܾ������D)
//            Intent destIntent = Intent.createChooser( intent, "����ɮ�" );
//            
//            // �������ɮ׿�ܾ� (�����B�z���G, �|Ĳ�o onActivityResult �ƥ�)
//            startActivityForResult(destIntent, 1);
            
      	  Mat cokeBGR = Highgui.imread("/storage/sdcard1/DCIM/Camera/IMG_20140804_183140.jpg");
          Bitmap bm = Bitmap.createBitmap(cokeBGR.cols(), cokeBGR.rows(), Bitmap.Config.ARGB_8888);
          Utils.matToBitmap(cokeBGR, bm);
          ImageView iv = (ImageView) findViewById(R.id.imageView1);
          iv.setImageBitmap(bm);
		}
//    	
    };
    
    
    private OnClickListener multichooseImage = new OnClickListener()
    {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent qa_intent = new Intent();  
			qa_intent.setClass(MainActivity.this, AndroidCustomGalleryActivity.class);
		    startActivity(qa_intent);    //Ĳ�o����
		    finish();   //��������
		}
    	
    };
    
    private OnClickListener calcBMI = new OnClickListener()
    {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
//			EditText et_height = (EditText)findViewById(R.id.editText1);
//			EditText et_weight = (EditText)findViewById(R.id.editText2);
//			
//			double h =  Double.parseDouble(et_height.getText().toString())/100;
//			double w =  Double.parseDouble(et_weight.getText().toString());
//			double bmi = w/(h*h);
//			
//			TextView res = (TextView)findViewById(R.id.textView2);
//			res.setText(" BMI: "+bmi);
		
			Intent qa_intent = new Intent();  
			qa_intent.setClass(MainActivity.this, Hey.class);
		    startActivity(qa_intent);    //Ĳ�o����
		    finish();   //��������
		}
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        
        // ������ɮ�
        if ( resultCode == RESULT_OK )
        {
            // ���o�ɮת� Uri
            Uri uri = data.getData();
            Log.v("LogDemo",uri.toString());
            
            if( uri != null )
            {
                // �Q�� Uri ��� ImageView �Ϥ�
                ImageView iv = (ImageView)this.findViewById(R.id.imageView1);
                iv.setImageURI( uri );
                
                setTitle( uri.toString() );
            }
            else
            {
                setTitle("�L�Ī��ɮ׸��| !!");
            }
        }
        else
        {
            setTitle("��������ɮ� !!");
        }
    }
   
}
