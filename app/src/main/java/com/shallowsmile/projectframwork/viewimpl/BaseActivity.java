�}�^  �Q  O��s�]�(�� ��A�7���%"�|J{j��1��a��ٺ�e��+>�\C���D$@�c��`A�A��r/2;6�F��x<nǲes*>(>ES
�$�\�l�;B0Ks�����7cD�~�	MtMC+��7D�l-�|$��@�F�v��${�R�R��l�au�� � t��gᣜ/�h��}��G��R�U%�%֤ ����GBS8A&0�X��U)��%hʓU��CXk,f��fO��}��{0ǳ�bX�䲟qs�'aBa.H�r4�I!��ZPbHc�;����^_�!�az!�̙�{��`�s<��'k��:gA7�>�S�SZ�
V�מᦑ"���E�iJI-�D��6 ��b �U��ij*�XnC�Z�>��ԣ����,��)$B�Q�d�\3���-����z�������t3_�j�4>�U�nRpWn�U�K�	�!�(�S42��#(�d��;�f;5YC	Y`{7u�x[�  presenter=initPresenter();
        presenter.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detTach();
            presenter=null;
        }
    }

    public abstract P initPresenter();


}
