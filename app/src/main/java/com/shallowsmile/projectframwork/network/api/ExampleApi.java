�}�^  �C  �̏�p-�� ��G�
����'�{����fnE#r)8����y�������$O������f������ʓ����U�N��f��Ƈ^јd%ɥݦأv%:�s2���<��
�^�ױ�0Iw��������8������0t�˙-�w�^����Qv C�7���g�p+�x0<�������R���GUp�ݪ��`W�`K�;�������M�a�cm���[�Q]��,؊S��*�0�ŀ�K���=G(ų�3k}����8�|{Q5b�������F�G�D��:�]=�v���GZ���1�G����Q%���X�\a�'�aM?��6{Z�
V�מᦑ"���E�iJI-�D��6 ��b �U��ij*�XnC�Z�>��ԣ����,��)$B�Q�d�\3���-����z�������t3_�j�4>�U�nRpWn�U�K�	�!�(�S42��#(�d��;�f;5YC	Y`{7u�x[�c.m.163.com/nc/article/headline/T1348647909107/{id}-20.html")
    Observable<Object> getNews(@Path("id") int id);

    /**
     * post  提交表单数据
     * @param first
     * @param last
     * @return
     */
    @FormUrlEncoded
    @POST("user/edit")
    Observable<Object> updateUser(@Field("first_name") String first, @Field("last_name") String last);
}
