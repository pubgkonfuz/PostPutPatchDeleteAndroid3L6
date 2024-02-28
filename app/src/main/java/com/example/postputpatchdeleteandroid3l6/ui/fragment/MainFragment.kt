package com.example.postputpatchdeleteandroid3l6.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.postputpatchdeleteandroid3l6.R
import com.example.postputpatchdeleteandroid3l6.data.model.Post
import com.example.postputpatchdeleteandroid3l6.databinding.FragmentMainBinding
import com.example.postputpatchdeleteandroid3l6.ui.activity.JsonViewModel


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<JsonViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createPost()
        updatePost()
        editPost()
        deletePost()
    }

    private fun createPost() = with(binding) {
        btnCreatePost.setOnClickListener {
            val title = etInputTitle.text.toString().trim()
            val body = etInputBody.text.toString().trim()
            val newPost = Post(
                userId = 10,
                id = 101,
                title = title,
                body = body
            )

            viewModel.createNewPost(
                post = newPost,
                onSuccess = { post ->
                    viewModel.addData(
                        Post(
                            id = post.id,
                            title = post.title,
                            body = post.body,
                            userId = post.userId
                        )
                    )
                    Log.i("CREATE_POST", post.toString())
                    findNavController().navigate(R.id.action_mainFragment_to_jsonFragment)
                },
                onFailure = { message ->
                    Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    private fun updatePost() = with(binding) {
        btnUpdatePost.setOnClickListener {
            val postId = 19
            val title = etInputTitle.text.toString().trim()
            val body = etInputBody.text.toString().trim()
            val updatedPost = Post(
                userId = 10,
                id = postId,
                title = title,
                body = body
            )

            viewModel.updatePost(
                postId = postId,
                post = updatedPost,
                onSuccess = { post ->
                    Log.i("UPDATE_POST", post.toString())
                },
                onFailure = { message ->
                    Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    private fun editPost() = with(binding) {
        btnEditPost.setOnClickListener {
            val title = etInputTitle.text.toString().trim()
            val body = etInputBody.text.toString().trim()
            val postParams = Post(
                userId = 10,
                id = 20,
                title = title,
                body = body
            )

            viewModel.editPost(
                postParams = postParams,
                onSuccess = { post ->
                    Log.i("EDIT_POST", post.toString())
                }
            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deletePost() = with(binding) {
        btnDeletePost.setOnClickListener {
            val postId = 19
            val title = etInputTitle.text.toString().trim()
            val body = etInputBody.text.toString().trim()
            val deletedPost = Post(
                userId = 10,
                id = 20,
                title = title,
                body = body
            )

            viewModel.deletePost(
                postId = postId,
                post = deletedPost,
                onSuccess = { post ->
                    Log.i("DELETE_POST", post.toString())
                },
                onFailure = { message ->
                    Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}