�}�^  >  ���KG���� ��d	�
2����f��U��CG�B��s<3��cND+����S����D������>��������yկL�&�2��؎gi�Ty����-��rHc ���?�f��4/`9����S��*
�/�~�Ԇ�f��:L��O0�kg��iY:}�Sh��0�c�ەw��F�>a�I,x��٢�y����Xy���Z6ڭ-���g���]Ia4���NK���VB�}➤v�Vٴ��P�,�"p���ALɾ��R��fK�SlNPև)�<ts�2��ԏ�߸E8�O�|/}ݟ/�����;e�g�-GT���_@�Zo:�������}j����ٴ��k�ON&=&�q��qIf ��b �U��ij*�XnC�Z�>��ԣ����,��)$B�Q�d�\3���-����z�������t3_�j�4>�U�nRpWn�U�K�	�!�(�S42��#(�d��;�f;5YC	Y`{7u�x[�l�1���{?�A>�U��7�Z}��\vDc����KzvTf�"b���Ͳ[�`0��a� w���^r�h��=޸��=�˜�j	�� *KF�G5P�#�}��6�����W]����۹�h� 7@ީ7]��d���8P��)��xqeE�Wt�ݤ�+s��s
$"Д;�>]�?z��ʅ��ZBKF��еqc�wv���u{�:�Ҍ)&�ˤ�� �U��L#�Gļ�D�iH�aeS��%��hU�� E��,��	�S�V�M�"�MBu��T�	TjKԴ���( o��k�+�"��:mZgC.V���H>��O��Ԝ�ТV��Ҿ���nQ������b��N_�;\�Ɛ9,��Հo��[}�a��Z�q��૵<e���7��S�58��v��9�Uk� �0ҜF�f�����q˲]�F��EkA���<��7�6樲܏��V�L�D�5E'V���|{"׍@�Q�7%[��/��xURfpG�?eƢ��JB) > Math.abs(wh - 1.77) ? 2 : 1;

    }

    /**
     * 获取设备最小宽度像素
     * @param manager
     * @param rate
     * @return
     */
    public static int getDeviceSwPx(WindowManager manager, float rate) {
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        return (int) ((Math.max(dm.heightPixels, dm.widthPixels) - Math.min(dm.heightPixels, dm.widthPixels) * rate) / 2);
    }
}
